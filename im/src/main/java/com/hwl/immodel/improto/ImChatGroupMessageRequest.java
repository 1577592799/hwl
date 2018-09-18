// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/java/com/hwl/im/protocol/im_message.proto

package com.hwl.im.core.proto;

/**
 * Protobuf type {@code ImChatGroupMessageRequest}
 */
public  final class ImChatGroupMessageRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ImChatGroupMessageRequest)
    ImChatGroupMessageRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ImChatGroupMessageRequest.newBuilder() to construct.
  private ImChatGroupMessageRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ImChatGroupMessageRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ImChatGroupMessageRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            com.hwl.im.core.proto.ImChatGroupMessageContent.Builder subBuilder = null;
            if (chatGroupMessageContent_ != null) {
              subBuilder = chatGroupMessageContent_.toBuilder();
            }
            chatGroupMessageContent_ = input.readMessage(com.hwl.im.core.proto.ImChatGroupMessageContent.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(chatGroupMessageContent_);
              chatGroupMessageContent_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.hwl.im.core.proto.ImMessage.internal_static_ImChatGroupMessageRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.hwl.im.core.proto.ImMessage.internal_static_ImChatGroupMessageRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.hwl.im.core.proto.ImChatGroupMessageRequest.class, com.hwl.im.core.proto.ImChatGroupMessageRequest.Builder.class);
  }

  public static final int CHATGROUPMESSAGECONTENT_FIELD_NUMBER = 1;
  private com.hwl.im.core.proto.ImChatGroupMessageContent chatGroupMessageContent_;
  /**
   * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
   */
  public boolean hasChatGroupMessageContent() {
    return chatGroupMessageContent_ != null;
  }
  /**
   * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
   */
  public com.hwl.im.core.proto.ImChatGroupMessageContent getChatGroupMessageContent() {
    return chatGroupMessageContent_ == null ? com.hwl.im.core.proto.ImChatGroupMessageContent.getDefaultInstance() : chatGroupMessageContent_;
  }
  /**
   * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
   */
  public com.hwl.im.core.proto.ImChatGroupMessageContentOrBuilder getChatGroupMessageContentOrBuilder() {
    return getChatGroupMessageContent();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (chatGroupMessageContent_ != null) {
      output.writeMessage(1, getChatGroupMessageContent());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (chatGroupMessageContent_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getChatGroupMessageContent());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.hwl.im.core.proto.ImChatGroupMessageRequest)) {
      return super.equals(obj);
    }
    com.hwl.im.core.proto.ImChatGroupMessageRequest other = (com.hwl.im.core.proto.ImChatGroupMessageRequest) obj;

    boolean result = true;
    result = result && (hasChatGroupMessageContent() == other.hasChatGroupMessageContent());
    if (hasChatGroupMessageContent()) {
      result = result && getChatGroupMessageContent()
          .equals(other.getChatGroupMessageContent());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasChatGroupMessageContent()) {
      hash = (37 * hash) + CHATGROUPMESSAGECONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getChatGroupMessageContent().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hwl.im.core.proto.ImChatGroupMessageRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.hwl.im.core.proto.ImChatGroupMessageRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ImChatGroupMessageRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ImChatGroupMessageRequest)
      com.hwl.im.core.proto.ImChatGroupMessageRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hwl.im.core.proto.ImMessage.internal_static_ImChatGroupMessageRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hwl.im.core.proto.ImMessage.internal_static_ImChatGroupMessageRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.hwl.im.core.proto.ImChatGroupMessageRequest.class, com.hwl.im.core.proto.ImChatGroupMessageRequest.Builder.class);
    }

    // Construct using com.hwl.im.core.proto.ImChatGroupMessageRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (chatGroupMessageContentBuilder_ == null) {
        chatGroupMessageContent_ = null;
      } else {
        chatGroupMessageContent_ = null;
        chatGroupMessageContentBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.hwl.im.core.proto.ImMessage.internal_static_ImChatGroupMessageRequest_descriptor;
    }

    public com.hwl.im.core.proto.ImChatGroupMessageRequest getDefaultInstanceForType() {
      return com.hwl.im.core.proto.ImChatGroupMessageRequest.getDefaultInstance();
    }

    public com.hwl.im.core.proto.ImChatGroupMessageRequest build() {
      com.hwl.im.core.proto.ImChatGroupMessageRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.hwl.im.core.proto.ImChatGroupMessageRequest buildPartial() {
      com.hwl.im.core.proto.ImChatGroupMessageRequest result = new com.hwl.im.core.proto.ImChatGroupMessageRequest(this);
      if (chatGroupMessageContentBuilder_ == null) {
        result.chatGroupMessageContent_ = chatGroupMessageContent_;
      } else {
        result.chatGroupMessageContent_ = chatGroupMessageContentBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.hwl.im.core.proto.ImChatGroupMessageRequest) {
        return mergeFrom((com.hwl.im.core.proto.ImChatGroupMessageRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.hwl.im.core.proto.ImChatGroupMessageRequest other) {
      if (other == com.hwl.im.core.proto.ImChatGroupMessageRequest.getDefaultInstance()) return this;
      if (other.hasChatGroupMessageContent()) {
        mergeChatGroupMessageContent(other.getChatGroupMessageContent());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.hwl.im.core.proto.ImChatGroupMessageRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.hwl.im.core.proto.ImChatGroupMessageRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.hwl.im.core.proto.ImChatGroupMessageContent chatGroupMessageContent_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.hwl.im.core.proto.ImChatGroupMessageContent, com.hwl.im.core.proto.ImChatGroupMessageContent.Builder, com.hwl.im.core.proto.ImChatGroupMessageContentOrBuilder> chatGroupMessageContentBuilder_;
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public boolean hasChatGroupMessageContent() {
      return chatGroupMessageContentBuilder_ != null || chatGroupMessageContent_ != null;
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public com.hwl.im.core.proto.ImChatGroupMessageContent getChatGroupMessageContent() {
      if (chatGroupMessageContentBuilder_ == null) {
        return chatGroupMessageContent_ == null ? com.hwl.im.core.proto.ImChatGroupMessageContent.getDefaultInstance() : chatGroupMessageContent_;
      } else {
        return chatGroupMessageContentBuilder_.getMessage();
      }
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public Builder setChatGroupMessageContent(com.hwl.im.core.proto.ImChatGroupMessageContent value) {
      if (chatGroupMessageContentBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        chatGroupMessageContent_ = value;
        onChanged();
      } else {
        chatGroupMessageContentBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public Builder setChatGroupMessageContent(
        com.hwl.im.core.proto.ImChatGroupMessageContent.Builder builderForValue) {
      if (chatGroupMessageContentBuilder_ == null) {
        chatGroupMessageContent_ = builderForValue.build();
        onChanged();
      } else {
        chatGroupMessageContentBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public Builder mergeChatGroupMessageContent(com.hwl.im.core.proto.ImChatGroupMessageContent value) {
      if (chatGroupMessageContentBuilder_ == null) {
        if (chatGroupMessageContent_ != null) {
          chatGroupMessageContent_ =
            com.hwl.im.core.proto.ImChatGroupMessageContent.newBuilder(chatGroupMessageContent_).mergeFrom(value).buildPartial();
        } else {
          chatGroupMessageContent_ = value;
        }
        onChanged();
      } else {
        chatGroupMessageContentBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public Builder clearChatGroupMessageContent() {
      if (chatGroupMessageContentBuilder_ == null) {
        chatGroupMessageContent_ = null;
        onChanged();
      } else {
        chatGroupMessageContent_ = null;
        chatGroupMessageContentBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public com.hwl.im.core.proto.ImChatGroupMessageContent.Builder getChatGroupMessageContentBuilder() {
      
      onChanged();
      return getChatGroupMessageContentFieldBuilder().getBuilder();
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    public com.hwl.im.core.proto.ImChatGroupMessageContentOrBuilder getChatGroupMessageContentOrBuilder() {
      if (chatGroupMessageContentBuilder_ != null) {
        return chatGroupMessageContentBuilder_.getMessageOrBuilder();
      } else {
        return chatGroupMessageContent_ == null ?
            com.hwl.im.core.proto.ImChatGroupMessageContent.getDefaultInstance() : chatGroupMessageContent_;
      }
    }
    /**
     * <code>.ImChatGroupMessageContent chatGroupMessageContent = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.hwl.im.core.proto.ImChatGroupMessageContent, com.hwl.im.core.proto.ImChatGroupMessageContent.Builder, com.hwl.im.core.proto.ImChatGroupMessageContentOrBuilder> 
        getChatGroupMessageContentFieldBuilder() {
      if (chatGroupMessageContentBuilder_ == null) {
        chatGroupMessageContentBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.hwl.im.core.proto.ImChatGroupMessageContent, com.hwl.im.core.proto.ImChatGroupMessageContent.Builder, com.hwl.im.core.proto.ImChatGroupMessageContentOrBuilder>(
                getChatGroupMessageContent(),
                getParentForChildren(),
                isClean());
        chatGroupMessageContent_ = null;
      }
      return chatGroupMessageContentBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ImChatGroupMessageRequest)
  }

  // @@protoc_insertion_point(class_scope:ImChatGroupMessageRequest)
  private static final com.hwl.im.core.proto.ImChatGroupMessageRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.hwl.im.core.proto.ImChatGroupMessageRequest();
  }

  public static com.hwl.im.core.proto.ImChatGroupMessageRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ImChatGroupMessageRequest>
      PARSER = new com.google.protobuf.AbstractParser<ImChatGroupMessageRequest>() {
    public ImChatGroupMessageRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ImChatGroupMessageRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ImChatGroupMessageRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ImChatGroupMessageRequest> getParserForType() {
    return PARSER;
  }

  public com.hwl.im.core.proto.ImChatGroupMessageRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

