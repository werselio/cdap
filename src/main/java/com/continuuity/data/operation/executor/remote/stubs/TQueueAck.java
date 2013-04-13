/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.continuuity.data.operation.executor.remote.stubs;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TQueueAck implements org.apache.thrift.TBase<TQueueAck, TQueueAck._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TQueueAck");

  private static final org.apache.thrift.protocol.TField QUEUE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("queueName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ENTRY_POINTERS_FIELD_DESC = new org.apache.thrift.protocol.TField("entryPointers", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField CONSUMER_FIELD_DESC = new org.apache.thrift.protocol.TField("consumer", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField NUM_GROUPS_FIELD_DESC = new org.apache.thrift.protocol.TField("numGroups", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField METRIC_FIELD_DESC = new org.apache.thrift.protocol.TField("metric", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TQueueAckStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TQueueAckTupleSchemeFactory());
  }

  public ByteBuffer queueName; // required
  public List<TQueueEntryPointer> entryPointers; // required
  public TQueueConsumer consumer; // required
  public int numGroups; // required
  public long id; // required
  public String metric; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    QUEUE_NAME((short)1, "queueName"),
    ENTRY_POINTERS((short)2, "entryPointers"),
    CONSUMER((short)3, "consumer"),
    NUM_GROUPS((short)4, "numGroups"),
    ID((short)5, "id"),
    METRIC((short)6, "metric");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // QUEUE_NAME
          return QUEUE_NAME;
        case 2: // ENTRY_POINTERS
          return ENTRY_POINTERS;
        case 3: // CONSUMER
          return CONSUMER;
        case 4: // NUM_GROUPS
          return NUM_GROUPS;
        case 5: // ID
          return ID;
        case 6: // METRIC
          return METRIC;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __NUMGROUPS_ISSET_ID = 0;
  private static final int __ID_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);
  private _Fields optionals[] = {_Fields.METRIC};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.QUEUE_NAME, new org.apache.thrift.meta_data.FieldMetaData("queueName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.ENTRY_POINTERS, new org.apache.thrift.meta_data.FieldMetaData("entryPointers", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TQueueEntryPointer.class))));
    tmpMap.put(_Fields.CONSUMER, new org.apache.thrift.meta_data.FieldMetaData("consumer", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TQueueConsumer.class)));
    tmpMap.put(_Fields.NUM_GROUPS, new org.apache.thrift.meta_data.FieldMetaData("numGroups", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.METRIC, new org.apache.thrift.meta_data.FieldMetaData("metric", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TQueueAck.class, metaDataMap);
  }

  public TQueueAck() {
  }

  public TQueueAck(
    ByteBuffer queueName,
    List<TQueueEntryPointer> entryPointers,
    TQueueConsumer consumer,
    int numGroups,
    long id)
  {
    this();
    this.queueName = queueName;
    this.entryPointers = entryPointers;
    this.consumer = consumer;
    this.numGroups = numGroups;
    setNumGroupsIsSet(true);
    this.id = id;
    setIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TQueueAck(TQueueAck other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetQueueName()) {
      this.queueName = org.apache.thrift.TBaseHelper.copyBinary(other.queueName);
;
    }
    if (other.isSetEntryPointers()) {
      List<TQueueEntryPointer> __this__entryPointers = new ArrayList<TQueueEntryPointer>();
      for (TQueueEntryPointer other_element : other.entryPointers) {
        __this__entryPointers.add(new TQueueEntryPointer(other_element));
      }
      this.entryPointers = __this__entryPointers;
    }
    if (other.isSetConsumer()) {
      this.consumer = new TQueueConsumer(other.consumer);
    }
    this.numGroups = other.numGroups;
    this.id = other.id;
    if (other.isSetMetric()) {
      this.metric = other.metric;
    }
  }

  public TQueueAck deepCopy() {
    return new TQueueAck(this);
  }

  @Override
  public void clear() {
    this.queueName = null;
    this.entryPointers = null;
    this.consumer = null;
    setNumGroupsIsSet(false);
    this.numGroups = 0;
    setIdIsSet(false);
    this.id = 0;
    this.metric = null;
  }

  public byte[] getQueueName() {
    setQueueName(org.apache.thrift.TBaseHelper.rightSize(queueName));
    return queueName == null ? null : queueName.array();
  }

  public ByteBuffer bufferForQueueName() {
    return queueName;
  }

  public TQueueAck setQueueName(byte[] queueName) {
    setQueueName(queueName == null ? (ByteBuffer)null : ByteBuffer.wrap(queueName));
    return this;
  }

  public TQueueAck setQueueName(ByteBuffer queueName) {
    this.queueName = queueName;
    return this;
  }

  public void unsetQueueName() {
    this.queueName = null;
  }

  /** Returns true if field queueName is set (has been assigned a value) and false otherwise */
  public boolean isSetQueueName() {
    return this.queueName != null;
  }

  public void setQueueNameIsSet(boolean value) {
    if (!value) {
      this.queueName = null;
    }
  }

  public int getEntryPointersSize() {
    return (this.entryPointers == null) ? 0 : this.entryPointers.size();
  }

  public java.util.Iterator<TQueueEntryPointer> getEntryPointersIterator() {
    return (this.entryPointers == null) ? null : this.entryPointers.iterator();
  }

  public void addToEntryPointers(TQueueEntryPointer elem) {
    if (this.entryPointers == null) {
      this.entryPointers = new ArrayList<TQueueEntryPointer>();
    }
    this.entryPointers.add(elem);
  }

  public List<TQueueEntryPointer> getEntryPointers() {
    return this.entryPointers;
  }

  public TQueueAck setEntryPointers(List<TQueueEntryPointer> entryPointers) {
    this.entryPointers = entryPointers;
    return this;
  }

  public void unsetEntryPointers() {
    this.entryPointers = null;
  }

  /** Returns true if field entryPointers is set (has been assigned a value) and false otherwise */
  public boolean isSetEntryPointers() {
    return this.entryPointers != null;
  }

  public void setEntryPointersIsSet(boolean value) {
    if (!value) {
      this.entryPointers = null;
    }
  }

  public TQueueConsumer getConsumer() {
    return this.consumer;
  }

  public TQueueAck setConsumer(TQueueConsumer consumer) {
    this.consumer = consumer;
    return this;
  }

  public void unsetConsumer() {
    this.consumer = null;
  }

  /** Returns true if field consumer is set (has been assigned a value) and false otherwise */
  public boolean isSetConsumer() {
    return this.consumer != null;
  }

  public void setConsumerIsSet(boolean value) {
    if (!value) {
      this.consumer = null;
    }
  }

  public int getNumGroups() {
    return this.numGroups;
  }

  public TQueueAck setNumGroups(int numGroups) {
    this.numGroups = numGroups;
    setNumGroupsIsSet(true);
    return this;
  }

  public void unsetNumGroups() {
    __isset_bit_vector.clear(__NUMGROUPS_ISSET_ID);
  }

  /** Returns true if field numGroups is set (has been assigned a value) and false otherwise */
  public boolean isSetNumGroups() {
    return __isset_bit_vector.get(__NUMGROUPS_ISSET_ID);
  }

  public void setNumGroupsIsSet(boolean value) {
    __isset_bit_vector.set(__NUMGROUPS_ISSET_ID, value);
  }

  public long getId() {
    return this.id;
  }

  public TQueueAck setId(long id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bit_vector.clear(__ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return __isset_bit_vector.get(__ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bit_vector.set(__ID_ISSET_ID, value);
  }

  public String getMetric() {
    return this.metric;
  }

  public TQueueAck setMetric(String metric) {
    this.metric = metric;
    return this;
  }

  public void unsetMetric() {
    this.metric = null;
  }

  /** Returns true if field metric is set (has been assigned a value) and false otherwise */
  public boolean isSetMetric() {
    return this.metric != null;
  }

  public void setMetricIsSet(boolean value) {
    if (!value) {
      this.metric = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case QUEUE_NAME:
      if (value == null) {
        unsetQueueName();
      } else {
        setQueueName((ByteBuffer)value);
      }
      break;

    case ENTRY_POINTERS:
      if (value == null) {
        unsetEntryPointers();
      } else {
        setEntryPointers((List<TQueueEntryPointer>)value);
      }
      break;

    case CONSUMER:
      if (value == null) {
        unsetConsumer();
      } else {
        setConsumer((TQueueConsumer)value);
      }
      break;

    case NUM_GROUPS:
      if (value == null) {
        unsetNumGroups();
      } else {
        setNumGroups((Integer)value);
      }
      break;

    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Long)value);
      }
      break;

    case METRIC:
      if (value == null) {
        unsetMetric();
      } else {
        setMetric((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case QUEUE_NAME:
      return getQueueName();

    case ENTRY_POINTERS:
      return getEntryPointers();

    case CONSUMER:
      return getConsumer();

    case NUM_GROUPS:
      return Integer.valueOf(getNumGroups());

    case ID:
      return Long.valueOf(getId());

    case METRIC:
      return getMetric();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case QUEUE_NAME:
      return isSetQueueName();
    case ENTRY_POINTERS:
      return isSetEntryPointers();
    case CONSUMER:
      return isSetConsumer();
    case NUM_GROUPS:
      return isSetNumGroups();
    case ID:
      return isSetId();
    case METRIC:
      return isSetMetric();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TQueueAck)
      return this.equals((TQueueAck)that);
    return false;
  }

  public boolean equals(TQueueAck that) {
    if (that == null)
      return false;

    boolean this_present_queueName = true && this.isSetQueueName();
    boolean that_present_queueName = true && that.isSetQueueName();
    if (this_present_queueName || that_present_queueName) {
      if (!(this_present_queueName && that_present_queueName))
        return false;
      if (!this.queueName.equals(that.queueName))
        return false;
    }

    boolean this_present_entryPointers = true && this.isSetEntryPointers();
    boolean that_present_entryPointers = true && that.isSetEntryPointers();
    if (this_present_entryPointers || that_present_entryPointers) {
      if (!(this_present_entryPointers && that_present_entryPointers))
        return false;
      if (!this.entryPointers.equals(that.entryPointers))
        return false;
    }

    boolean this_present_consumer = true && this.isSetConsumer();
    boolean that_present_consumer = true && that.isSetConsumer();
    if (this_present_consumer || that_present_consumer) {
      if (!(this_present_consumer && that_present_consumer))
        return false;
      if (!this.consumer.equals(that.consumer))
        return false;
    }

    boolean this_present_numGroups = true;
    boolean that_present_numGroups = true;
    if (this_present_numGroups || that_present_numGroups) {
      if (!(this_present_numGroups && that_present_numGroups))
        return false;
      if (this.numGroups != that.numGroups)
        return false;
    }

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_metric = true && this.isSetMetric();
    boolean that_present_metric = true && that.isSetMetric();
    if (this_present_metric || that_present_metric) {
      if (!(this_present_metric && that_present_metric))
        return false;
      if (!this.metric.equals(that.metric))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TQueueAck other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TQueueAck typedOther = (TQueueAck)other;

    lastComparison = Boolean.valueOf(isSetQueueName()).compareTo(typedOther.isSetQueueName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetQueueName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.queueName, typedOther.queueName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEntryPointers()).compareTo(typedOther.isSetEntryPointers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEntryPointers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.entryPointers, typedOther.entryPointers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetConsumer()).compareTo(typedOther.isSetConsumer());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConsumer()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.consumer, typedOther.consumer);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNumGroups()).compareTo(typedOther.isSetNumGroups());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumGroups()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numGroups, typedOther.numGroups);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMetric()).compareTo(typedOther.isSetMetric());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMetric()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.metric, typedOther.metric);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TQueueAck(");
    boolean first = true;

    sb.append("queueName:");
    if (this.queueName == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.queueName, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("entryPointers:");
    if (this.entryPointers == null) {
      sb.append("null");
    } else {
      sb.append(this.entryPointers);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("consumer:");
    if (this.consumer == null) {
      sb.append("null");
    } else {
      sb.append(this.consumer);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("numGroups:");
    sb.append(this.numGroups);
    first = false;
    if (!first) sb.append(", ");
    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (isSetMetric()) {
      if (!first) sb.append(", ");
      sb.append("metric:");
      if (this.metric == null) {
        sb.append("null");
      } else {
        sb.append(this.metric);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TQueueAckStandardSchemeFactory implements SchemeFactory {
    public TQueueAckStandardScheme getScheme() {
      return new TQueueAckStandardScheme();
    }
  }

  private static class TQueueAckStandardScheme extends StandardScheme<TQueueAck> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TQueueAck struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // QUEUE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.queueName = iprot.readBinary();
              struct.setQueueNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ENTRY_POINTERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list66 = iprot.readListBegin();
                struct.entryPointers = new ArrayList<TQueueEntryPointer>(_list66.size);
                for (int _i67 = 0; _i67 < _list66.size; ++_i67)
                {
                  TQueueEntryPointer _elem68; // required
                  _elem68 = new TQueueEntryPointer();
                  _elem68.read(iprot);
                  struct.entryPointers.add(_elem68);
                }
                iprot.readListEnd();
              }
              struct.setEntryPointersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CONSUMER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.consumer = new TQueueConsumer();
              struct.consumer.read(iprot);
              struct.setConsumerIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NUM_GROUPS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.numGroups = iprot.readI32();
              struct.setNumGroupsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id = iprot.readI64();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // METRIC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.metric = iprot.readString();
              struct.setMetricIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TQueueAck struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.queueName != null) {
        oprot.writeFieldBegin(QUEUE_NAME_FIELD_DESC);
        oprot.writeBinary(struct.queueName);
        oprot.writeFieldEnd();
      }
      if (struct.entryPointers != null) {
        oprot.writeFieldBegin(ENTRY_POINTERS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.entryPointers.size()));
          for (TQueueEntryPointer _iter69 : struct.entryPointers)
          {
            _iter69.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.consumer != null) {
        oprot.writeFieldBegin(CONSUMER_FIELD_DESC);
        struct.consumer.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(NUM_GROUPS_FIELD_DESC);
      oprot.writeI32(struct.numGroups);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI64(struct.id);
      oprot.writeFieldEnd();
      if (struct.metric != null) {
        if (struct.isSetMetric()) {
          oprot.writeFieldBegin(METRIC_FIELD_DESC);
          oprot.writeString(struct.metric);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TQueueAckTupleSchemeFactory implements SchemeFactory {
    public TQueueAckTupleScheme getScheme() {
      return new TQueueAckTupleScheme();
    }
  }

  private static class TQueueAckTupleScheme extends TupleScheme<TQueueAck> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TQueueAck struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetQueueName()) {
        optionals.set(0);
      }
      if (struct.isSetEntryPointers()) {
        optionals.set(1);
      }
      if (struct.isSetConsumer()) {
        optionals.set(2);
      }
      if (struct.isSetNumGroups()) {
        optionals.set(3);
      }
      if (struct.isSetId()) {
        optionals.set(4);
      }
      if (struct.isSetMetric()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetQueueName()) {
        oprot.writeBinary(struct.queueName);
      }
      if (struct.isSetEntryPointers()) {
        {
          oprot.writeI32(struct.entryPointers.size());
          for (TQueueEntryPointer _iter70 : struct.entryPointers)
          {
            _iter70.write(oprot);
          }
        }
      }
      if (struct.isSetConsumer()) {
        struct.consumer.write(oprot);
      }
      if (struct.isSetNumGroups()) {
        oprot.writeI32(struct.numGroups);
      }
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetMetric()) {
        oprot.writeString(struct.metric);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TQueueAck struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.queueName = iprot.readBinary();
        struct.setQueueNameIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list71 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.entryPointers = new ArrayList<TQueueEntryPointer>(_list71.size);
          for (int _i72 = 0; _i72 < _list71.size; ++_i72)
          {
            TQueueEntryPointer _elem73; // required
            _elem73 = new TQueueEntryPointer();
            _elem73.read(iprot);
            struct.entryPointers.add(_elem73);
          }
        }
        struct.setEntryPointersIsSet(true);
      }
      if (incoming.get(2)) {
        struct.consumer = new TQueueConsumer();
        struct.consumer.read(iprot);
        struct.setConsumerIsSet(true);
      }
      if (incoming.get(3)) {
        struct.numGroups = iprot.readI32();
        struct.setNumGroupsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(5)) {
        struct.metric = iprot.readString();
        struct.setMetricIsSet(true);
      }
    }
  }

}

