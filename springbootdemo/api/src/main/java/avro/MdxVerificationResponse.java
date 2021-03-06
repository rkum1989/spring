/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MdxVerificationResponse extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2724900904395035095L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MdxVerificationResponse\",\"namespace\":\"avro\",\"fields\":[{\"name\":\"GroupResultReasons\",\"type\":{\"type\":\"record\",\"name\":\"GroupResultReasons\",\"fields\":[{\"name\":\"reasonCode\",\"type\":\"string\"},{\"name\":\"reasonText\",\"type\":\"string\"},{\"name\":\"additionalInfo\",\"type\":\"string\"},{\"name\":\"grade\",\"type\":\"string\"}]}},{\"name\":\"SystemErrors\",\"type\":{\"type\":\"record\",\"name\":\"SystemErrors\",\"fields\":[{\"name\":\"applicationID\",\"type\":\"string\"},{\"name\":\"code\",\"type\":\"string\"},{\"name\":\"subcode\",\"type\":\"string\"},{\"name\":\"message\",\"type\":\"string\"}]}},{\"name\":\"StatusMessages\",\"type\":{\"type\":\"record\",\"name\":\"StatusMessages\",\"fields\":[{\"name\":\"code\",\"type\":\"string\"},{\"name\":\"subcode\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"message\",\"type\":\"string\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private avro.GroupResultReasons GroupResultReasons;
   private avro.SystemErrors SystemErrors;
   private avro.StatusMessages StatusMessages;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MdxVerificationResponse() {}

  /**
   * All-args constructor.
   * @param GroupResultReasons The new value for GroupResultReasons
   * @param SystemErrors The new value for SystemErrors
   * @param StatusMessages The new value for StatusMessages
   */
  public MdxVerificationResponse(avro.GroupResultReasons GroupResultReasons, avro.SystemErrors SystemErrors, avro.StatusMessages StatusMessages) {
    this.GroupResultReasons = GroupResultReasons;
    this.SystemErrors = SystemErrors;
    this.StatusMessages = StatusMessages;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return GroupResultReasons;
    case 1: return SystemErrors;
    case 2: return StatusMessages;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: GroupResultReasons = (avro.GroupResultReasons)value$; break;
    case 1: SystemErrors = (avro.SystemErrors)value$; break;
    case 2: StatusMessages = (avro.StatusMessages)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'GroupResultReasons' field.
   * @return The value of the 'GroupResultReasons' field.
   */
  public avro.GroupResultReasons getGroupResultReasons() {
    return GroupResultReasons;
  }


  /**
   * Gets the value of the 'SystemErrors' field.
   * @return The value of the 'SystemErrors' field.
   */
  public avro.SystemErrors getSystemErrors() {
    return SystemErrors;
  }


  /**
   * Gets the value of the 'StatusMessages' field.
   * @return The value of the 'StatusMessages' field.
   */
  public avro.StatusMessages getStatusMessages() {
    return StatusMessages;
  }


  /**
   * Creates a new MdxVerificationResponse RecordBuilder.
   * @return A new MdxVerificationResponse RecordBuilder
   */
  public static avro.MdxVerificationResponse.Builder newBuilder() {
    return new avro.MdxVerificationResponse.Builder();
  }

  /**
   * Creates a new MdxVerificationResponse RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MdxVerificationResponse RecordBuilder
   */
  public static avro.MdxVerificationResponse.Builder newBuilder(avro.MdxVerificationResponse.Builder other) {
    return new avro.MdxVerificationResponse.Builder(other);
  }

  /**
   * Creates a new MdxVerificationResponse RecordBuilder by copying an existing MdxVerificationResponse instance.
   * @param other The existing instance to copy.
   * @return A new MdxVerificationResponse RecordBuilder
   */
  public static avro.MdxVerificationResponse.Builder newBuilder(avro.MdxVerificationResponse other) {
    return new avro.MdxVerificationResponse.Builder(other);
  }

  /**
   * RecordBuilder for MdxVerificationResponse instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MdxVerificationResponse>
    implements org.apache.avro.data.RecordBuilder<MdxVerificationResponse> {

    private avro.GroupResultReasons GroupResultReasons;
    private avro.GroupResultReasons.Builder GroupResultReasonsBuilder;
    private avro.SystemErrors SystemErrors;
    private avro.SystemErrors.Builder SystemErrorsBuilder;
    private avro.StatusMessages StatusMessages;
    private avro.StatusMessages.Builder StatusMessagesBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(avro.MdxVerificationResponse.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.GroupResultReasons)) {
        this.GroupResultReasons = data().deepCopy(fields()[0].schema(), other.GroupResultReasons);
        fieldSetFlags()[0] = true;
      }
      if (other.hasGroupResultReasonsBuilder()) {
        this.GroupResultReasonsBuilder = avro.GroupResultReasons.newBuilder(other.getGroupResultReasonsBuilder());
      }
      if (isValidValue(fields()[1], other.SystemErrors)) {
        this.SystemErrors = data().deepCopy(fields()[1].schema(), other.SystemErrors);
        fieldSetFlags()[1] = true;
      }
      if (other.hasSystemErrorsBuilder()) {
        this.SystemErrorsBuilder = avro.SystemErrors.newBuilder(other.getSystemErrorsBuilder());
      }
      if (isValidValue(fields()[2], other.StatusMessages)) {
        this.StatusMessages = data().deepCopy(fields()[2].schema(), other.StatusMessages);
        fieldSetFlags()[2] = true;
      }
      if (other.hasStatusMessagesBuilder()) {
        this.StatusMessagesBuilder = avro.StatusMessages.newBuilder(other.getStatusMessagesBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing MdxVerificationResponse instance
     * @param other The existing instance to copy.
     */
    private Builder(avro.MdxVerificationResponse other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.GroupResultReasons)) {
        this.GroupResultReasons = data().deepCopy(fields()[0].schema(), other.GroupResultReasons);
        fieldSetFlags()[0] = true;
      }
      this.GroupResultReasonsBuilder = null;
      if (isValidValue(fields()[1], other.SystemErrors)) {
        this.SystemErrors = data().deepCopy(fields()[1].schema(), other.SystemErrors);
        fieldSetFlags()[1] = true;
      }
      this.SystemErrorsBuilder = null;
      if (isValidValue(fields()[2], other.StatusMessages)) {
        this.StatusMessages = data().deepCopy(fields()[2].schema(), other.StatusMessages);
        fieldSetFlags()[2] = true;
      }
      this.StatusMessagesBuilder = null;
    }

    /**
      * Gets the value of the 'GroupResultReasons' field.
      * @return The value.
      */
    public avro.GroupResultReasons getGroupResultReasons() {
      return GroupResultReasons;
    }

    /**
      * Sets the value of the 'GroupResultReasons' field.
      * @param value The value of 'GroupResultReasons'.
      * @return This builder.
      */
    public avro.MdxVerificationResponse.Builder setGroupResultReasons(avro.GroupResultReasons value) {
      validate(fields()[0], value);
      this.GroupResultReasonsBuilder = null;
      this.GroupResultReasons = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'GroupResultReasons' field has been set.
      * @return True if the 'GroupResultReasons' field has been set, false otherwise.
      */
    public boolean hasGroupResultReasons() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'GroupResultReasons' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public avro.GroupResultReasons.Builder getGroupResultReasonsBuilder() {
      if (GroupResultReasonsBuilder == null) {
        if (hasGroupResultReasons()) {
          setGroupResultReasonsBuilder(avro.GroupResultReasons.newBuilder(GroupResultReasons));
        } else {
          setGroupResultReasonsBuilder(avro.GroupResultReasons.newBuilder());
        }
      }
      return GroupResultReasonsBuilder;
    }

    /**
     * Sets the Builder instance for the 'GroupResultReasons' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public avro.MdxVerificationResponse.Builder setGroupResultReasonsBuilder(avro.GroupResultReasons.Builder value) {
      clearGroupResultReasons();
      GroupResultReasonsBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'GroupResultReasons' field has an active Builder instance
     * @return True if the 'GroupResultReasons' field has an active Builder instance
     */
    public boolean hasGroupResultReasonsBuilder() {
      return GroupResultReasonsBuilder != null;
    }

    /**
      * Clears the value of the 'GroupResultReasons' field.
      * @return This builder.
      */
    public avro.MdxVerificationResponse.Builder clearGroupResultReasons() {
      GroupResultReasons = null;
      GroupResultReasonsBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'SystemErrors' field.
      * @return The value.
      */
    public avro.SystemErrors getSystemErrors() {
      return SystemErrors;
    }

    /**
      * Sets the value of the 'SystemErrors' field.
      * @param value The value of 'SystemErrors'.
      * @return This builder.
      */
    public avro.MdxVerificationResponse.Builder setSystemErrors(avro.SystemErrors value) {
      validate(fields()[1], value);
      this.SystemErrorsBuilder = null;
      this.SystemErrors = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'SystemErrors' field has been set.
      * @return True if the 'SystemErrors' field has been set, false otherwise.
      */
    public boolean hasSystemErrors() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'SystemErrors' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public avro.SystemErrors.Builder getSystemErrorsBuilder() {
      if (SystemErrorsBuilder == null) {
        if (hasSystemErrors()) {
          setSystemErrorsBuilder(avro.SystemErrors.newBuilder(SystemErrors));
        } else {
          setSystemErrorsBuilder(avro.SystemErrors.newBuilder());
        }
      }
      return SystemErrorsBuilder;
    }

    /**
     * Sets the Builder instance for the 'SystemErrors' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public avro.MdxVerificationResponse.Builder setSystemErrorsBuilder(avro.SystemErrors.Builder value) {
      clearSystemErrors();
      SystemErrorsBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'SystemErrors' field has an active Builder instance
     * @return True if the 'SystemErrors' field has an active Builder instance
     */
    public boolean hasSystemErrorsBuilder() {
      return SystemErrorsBuilder != null;
    }

    /**
      * Clears the value of the 'SystemErrors' field.
      * @return This builder.
      */
    public avro.MdxVerificationResponse.Builder clearSystemErrors() {
      SystemErrors = null;
      SystemErrorsBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'StatusMessages' field.
      * @return The value.
      */
    public avro.StatusMessages getStatusMessages() {
      return StatusMessages;
    }

    /**
      * Sets the value of the 'StatusMessages' field.
      * @param value The value of 'StatusMessages'.
      * @return This builder.
      */
    public avro.MdxVerificationResponse.Builder setStatusMessages(avro.StatusMessages value) {
      validate(fields()[2], value);
      this.StatusMessagesBuilder = null;
      this.StatusMessages = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'StatusMessages' field has been set.
      * @return True if the 'StatusMessages' field has been set, false otherwise.
      */
    public boolean hasStatusMessages() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'StatusMessages' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public avro.StatusMessages.Builder getStatusMessagesBuilder() {
      if (StatusMessagesBuilder == null) {
        if (hasStatusMessages()) {
          setStatusMessagesBuilder(avro.StatusMessages.newBuilder(StatusMessages));
        } else {
          setStatusMessagesBuilder(avro.StatusMessages.newBuilder());
        }
      }
      return StatusMessagesBuilder;
    }

    /**
     * Sets the Builder instance for the 'StatusMessages' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public avro.MdxVerificationResponse.Builder setStatusMessagesBuilder(avro.StatusMessages.Builder value) {
      clearStatusMessages();
      StatusMessagesBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'StatusMessages' field has an active Builder instance
     * @return True if the 'StatusMessages' field has an active Builder instance
     */
    public boolean hasStatusMessagesBuilder() {
      return StatusMessagesBuilder != null;
    }

    /**
      * Clears the value of the 'StatusMessages' field.
      * @return This builder.
      */
    public avro.MdxVerificationResponse.Builder clearStatusMessages() {
      StatusMessages = null;
      StatusMessagesBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public MdxVerificationResponse build() {
      try {
        MdxVerificationResponse record = new MdxVerificationResponse();
        if (GroupResultReasonsBuilder != null) {
          record.GroupResultReasons = this.GroupResultReasonsBuilder.build();
        } else {
          record.GroupResultReasons = fieldSetFlags()[0] ? this.GroupResultReasons : (avro.GroupResultReasons) defaultValue(fields()[0]);
        }
        if (SystemErrorsBuilder != null) {
          record.SystemErrors = this.SystemErrorsBuilder.build();
        } else {
          record.SystemErrors = fieldSetFlags()[1] ? this.SystemErrors : (avro.SystemErrors) defaultValue(fields()[1]);
        }
        if (StatusMessagesBuilder != null) {
          record.StatusMessages = this.StatusMessagesBuilder.build();
        } else {
          record.StatusMessages = fieldSetFlags()[2] ? this.StatusMessages : (avro.StatusMessages) defaultValue(fields()[2]);
        }
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
