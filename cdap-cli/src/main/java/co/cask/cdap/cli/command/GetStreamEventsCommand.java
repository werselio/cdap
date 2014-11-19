/*
 * Copyright © 2014 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.cdap.cli.command;

import co.cask.cdap.api.flow.flowlet.StreamEvent;
import co.cask.cdap.cli.ArgumentName;
import co.cask.cdap.cli.ElementType;
import co.cask.cdap.cli.util.AsciiTable;
import co.cask.cdap.cli.util.ResponseUtil;
import co.cask.cdap.cli.util.RowMaker;
import co.cask.cdap.cli.util.TimestampUtil;
import co.cask.cdap.client.StreamClient;
import co.cask.common.cli.Arguments;
import co.cask.common.cli.Command;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

import java.io.PrintStream;
import java.util.List;

/**
 * A CLI command for getting stream events.
 */
public class GetStreamEventsCommand implements Command {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator");

  private final StreamClient streamClient;

  @Inject
  public GetStreamEventsCommand(StreamClient streamClient) {
    this.streamClient = streamClient;
  }

  @Override
  public void execute(Arguments arguments, PrintStream output) throws Exception {
    long currentTime = System.currentTimeMillis();

    String streamId = arguments.get(ArgumentName.STREAM.toString());
    long startTime = TimestampUtil.getTimestamp(arguments.get(ArgumentName.START_TIME.toString(), "min"), currentTime);
    long endTime = TimestampUtil.getTimestamp(arguments.get(ArgumentName.END_TIME.toString(), "max"), currentTime);
    int limit = arguments.getInt(ArgumentName.LIMIT.toString(), Integer.MAX_VALUE);

    // Get a list of stream events and prints it.
    List<StreamEvent> events = streamClient.getEvents(streamId, startTime, endTime,
                                                      limit, Lists.<StreamEvent>newArrayList());
    new AsciiTable<StreamEvent>(
      new String[] { "timestamp", "headers", "body size", "body"},
      events,
      new RowMaker<StreamEvent>() {
        @Override
        public Object[] makeRow(StreamEvent event) {
          long bodySize = event.getBody().remaining();

          return new Object[] {
            event.getTimestamp(),
            event.getHeaders().isEmpty() ? "" : ResponseUtil.formatHeader(event.getHeaders()),
            bodySize,
            ResponseUtil.getBody(event.getBody())
          };
        }
      }
    ).print(output);
  }

  @Override
  public String getPattern() {
    return String.format("get stream <%s> [<%s>] [<%s>] [<%s>]",
                         ArgumentName.STREAM, ArgumentName.START_TIME, ArgumentName.END_TIME, ArgumentName.LIMIT);
  }

  @Override
  public String getDescription() {
    return "Gets events from a " + ElementType.STREAM.getPrettyName() + ". " +
      "The time format for <start-time> and <end-time> could be timestamp in milliseconds or " +
      "relative time in the form of [+\\-][0-9]+[hms]. " +
      "For <start-time>, it is relative to current time, " +
      "while for <end-time>, it's relative to start time. " +
      "Special constants \"min\" and \"max\" can also be used to represent 0 and max timestamp respectively.";
  }

}
