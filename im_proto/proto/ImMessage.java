// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/java/com/hwl/im/protocol/im_message.proto

package com.hwl.im.core.proto;

public final class ImMessage {
  private ImMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImMessageContext_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImMessageContext_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImMessageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImMessageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImMessageRequestHead_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImMessageRequestHead_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImMessageResponseHead_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImMessageResponseHead_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImUserValidateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImUserValidateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImUserValidateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImUserValidateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImChatUserMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImChatUserMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImChatUserMessageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImChatUserMessageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImChatUserMessageContent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImChatUserMessageContent_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImChatGroupMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImChatGroupMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImChatGroupMessageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImChatGroupMessageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImChatGroupMessageContent_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImChatGroupMessageContent_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ImHeartBeatMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ImHeartBeatMessageRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n2src/main/java/com/hwl/im/protocol/im_m" +
      "essage.proto\"\206\001\n\020ImMessageContext\022\034\n\004typ" +
      "e\030\001 \001(\0162\016.ImMessageType\022$\n\007request\030\002 \001(\013" +
      "2\021.ImMessageRequestH\000\022&\n\010response\030\003 \001(\0132" +
      "\022.ImMessageResponseH\000B\006\n\004body\"\277\002\n\020ImMess" +
      "ageRequest\022*\n\013requestHead\030\001 \001(\0132\025.ImMess" +
      "ageRequestHead\0225\n\023userValidateRequest\030\002 " +
      "\001(\0132\026.ImUserValidateRequestH\000\022;\n\026chatUse" +
      "rMessageRequest\030\003 \001(\0132\031.ImChatUserMessag" +
      "eRequestH\000\022=\n\027chatGroupMessageRequest\030\004 " +
      "\001(\0132\032.ImChatGroupMessageRequestH\000\022=\n\027hea" +
      "rtBeatMessageRequest\030\005 \001(\0132\032.ImHeartBeat" +
      "MessageRequestH\000B\r\n\013requestBody\"\212\002\n\021ImMe" +
      "ssageResponse\022,\n\014responseHead\030\001 \001(\0132\026.Im" +
      "MessageResponseHead\0227\n\024userValidateRespo" +
      "nse\030\002 \001(\0132\027.ImUserValidateResponseH\000\022=\n\027" +
      "chatUserMessageResponse\030\003 \001(\0132\032.ImChatUs" +
      "erMessageResponseH\000\022?\n\030chatGroupMessageR" +
      "esponse\030\004 \001(\0132\033.ImChatGroupMessageRespon" +
      "seH\000B\016\n\014responseBody\"o\n\024ImMessageRequest" +
      "Head\022\021\n\ttimestamp\030\001 \001(\004\022\016\n\006client\030\002 \001(\t\022" +
      "\021\n\tsessionid\030\003 \001(\t\022\020\n\010language\030\004 \001(\t\022\017\n\007" +
      "version\030\005 \001(\t\"`\n\025ImMessageResponseHead\022\014" +
      "\n\004code\030\001 \001(\r\022\017\n\007message\030\002 \001(\t\022(\n\006source\030" +
      "\003 \001(\0162\030.ImMessageSourcePosition\"6\n\025ImUse" +
      "rValidateRequest\022\016\n\006userId\030\001 \001(\004\022\r\n\005toke" +
      "n\030\002 \001(\t\"a\n\026ImUserValidateResponse\022\021\n\tisS" +
      "uccess\030\001 \001(\010\022\017\n\007message\030\002 \001(\t\022\020\n\010isOnlin" +
      "e\030\003 \001(\010\022\021\n\tsessionid\030\004 \001(\t\"U\n\030ImChatUser" +
      "MessageRequest\0229\n\026chatUserMessageContent" +
      "\030\001 \001(\0132\031.ImChatUserMessageContent\"i\n\031ImC" +
      "hatUserMessageResponse\0229\n\026chatUserMessag" +
      "eContent\030\001 \001(\0132\031.ImChatUserMessageConten" +
      "t\022\021\n\tbuildTime\030\002 \001(\004\"\360\001\n\030ImChatUserMessa" +
      "geContent\022\022\n\nfromUserId\030\001 \001(\004\022\024\n\014fromUse" +
      "rName\030\002 \001(\t\022\025\n\rfromUserImage\030\003 \001(\t\022\020\n\010to" +
      "UserId\030\004 \001(\004\022\023\n\013contentType\030\005 \001(\r\022\017\n\007con" +
      "tent\030\006 \001(\t\022\022\n\npreviewUrl\030\007 \001(\t\022\022\n\nimageW" +
      "idth\030\010 \001(\r\022\023\n\013imageHeight\030\t \001(\r\022\014\n\004size\030" +
      "\n \001(\r\022\020\n\010playTime\030\013 \001(\r\"X\n\031ImChatGroupMe" +
      "ssageRequest\022;\n\027chatGroupMessageContent\030" +
      "\001 \001(\0132\032.ImChatGroupMessageContent\"l\n\032ImC" +
      "hatGroupMessageResponse\022;\n\027chatGroupMess" +
      "ageContent\030\001 \001(\0132\032.ImChatGroupMessageCon" +
      "tent\022\021\n\tbuildTime\030\002 \001(\004\"\365\001\n\031ImChatGroupM" +
      "essageContent\022\022\n\nfromUserId\030\001 \001(\004\022\024\n\014fro" +
      "mUserName\030\002 \001(\t\022\025\n\rfromUserImage\030\003 \001(\t\022\024" +
      "\n\014toGrouopGuid\030\004 \001(\t\022\023\n\013contentType\030\005 \001(" +
      "\r\022\017\n\007content\030\006 \001(\t\022\022\n\npreviewUrl\030\007 \001(\t\022\022" +
      "\n\nimageWidth\030\010 \001(\r\022\023\n\013imageHeight\030\t \001(\r\022" +
      "\014\n\004size\030\n \001(\r\022\020\n\010playTime\030\013 \001(\r\"0\n\031ImHea" +
      "rtBeatMessageRequest\022\023\n\013currentTime\030\001 \001(" +
      "\004*W\n\rImMessageType\022\010\n\004Base\020\000\022\020\n\014UserVali" +
      "date\020\001\022\014\n\010ChatUser\020\002\022\r\n\tChatGroup\020\003\022\r\n\tH" +
      "eartBeat\020\004*S\n\025ImMessageResponseCode\022\t\n\005O" +
      "ther\020\000\022\013\n\007Success\020d\022\013\n\006Failed\020\310\001\022\025\n\020Sess" +
      "ionidInvalid\020\311\001*I\n\027ImMessageSourcePositi" +
      "on\022\010\n\004None\020\000\022\014\n\010RealTime\020\001\022\013\n\007Offline\020\002\022" +
      "\t\n\005Retry\020\003B+\n\025com.hwl.im.core.protoP\001\252\002\017" +
      "IMCore.Protocolb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ImMessageContext_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ImMessageContext_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImMessageContext_descriptor,
        new java.lang.String[] { "Type", "Request", "Response", "Body", });
    internal_static_ImMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ImMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImMessageRequest_descriptor,
        new java.lang.String[] { "RequestHead", "UserValidateRequest", "ChatUserMessageRequest", "ChatGroupMessageRequest", "HeartBeatMessageRequest", "RequestBody", });
    internal_static_ImMessageResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ImMessageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImMessageResponse_descriptor,
        new java.lang.String[] { "ResponseHead", "UserValidateResponse", "ChatUserMessageResponse", "ChatGroupMessageResponse", "ResponseBody", });
    internal_static_ImMessageRequestHead_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ImMessageRequestHead_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImMessageRequestHead_descriptor,
        new java.lang.String[] { "Timestamp", "Client", "Sessionid", "Language", "Version", });
    internal_static_ImMessageResponseHead_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ImMessageResponseHead_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImMessageResponseHead_descriptor,
        new java.lang.String[] { "Code", "Message", "Source", });
    internal_static_ImUserValidateRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ImUserValidateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImUserValidateRequest_descriptor,
        new java.lang.String[] { "UserId", "Token", });
    internal_static_ImUserValidateResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_ImUserValidateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImUserValidateResponse_descriptor,
        new java.lang.String[] { "IsSuccess", "Message", "IsOnline", "Sessionid", });
    internal_static_ImChatUserMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ImChatUserMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImChatUserMessageRequest_descriptor,
        new java.lang.String[] { "ChatUserMessageContent", });
    internal_static_ImChatUserMessageResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_ImChatUserMessageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImChatUserMessageResponse_descriptor,
        new java.lang.String[] { "ChatUserMessageContent", "BuildTime", });
    internal_static_ImChatUserMessageContent_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_ImChatUserMessageContent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImChatUserMessageContent_descriptor,
        new java.lang.String[] { "FromUserId", "FromUserName", "FromUserImage", "ToUserId", "ContentType", "Content", "PreviewUrl", "ImageWidth", "ImageHeight", "Size", "PlayTime", });
    internal_static_ImChatGroupMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_ImChatGroupMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImChatGroupMessageRequest_descriptor,
        new java.lang.String[] { "ChatGroupMessageContent", });
    internal_static_ImChatGroupMessageResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_ImChatGroupMessageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImChatGroupMessageResponse_descriptor,
        new java.lang.String[] { "ChatGroupMessageContent", "BuildTime", });
    internal_static_ImChatGroupMessageContent_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_ImChatGroupMessageContent_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImChatGroupMessageContent_descriptor,
        new java.lang.String[] { "FromUserId", "FromUserName", "FromUserImage", "ToGrouopGuid", "ContentType", "Content", "PreviewUrl", "ImageWidth", "ImageHeight", "Size", "PlayTime", });
    internal_static_ImHeartBeatMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_ImHeartBeatMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ImHeartBeatMessageRequest_descriptor,
        new java.lang.String[] { "CurrentTime", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
