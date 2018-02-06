package rokid.inner;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: tts.proto")
public final class TtsServiceGrpc {

  private TtsServiceGrpc() {}

  public static final String SERVICE_NAME = "rokid.inner.TtsService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<rokid.inner.Tts.TtsRequest,
      rokid.inner.Tts.TtsResponse> METHOD_TTS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "rokid.inner.TtsService", "tts"),
          io.grpc.protobuf.ProtoUtils.marshaller(rokid.inner.Tts.TtsRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(rokid.inner.Tts.TtsResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TtsServiceStub newStub(io.grpc.Channel channel) {
    return new TtsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TtsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TtsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static TtsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TtsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TtsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void tts(rokid.inner.Tts.TtsRequest request,
        io.grpc.stub.StreamObserver<rokid.inner.Tts.TtsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_TTS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_TTS,
            asyncServerStreamingCall(
              new MethodHandlers<
                rokid.inner.Tts.TtsRequest,
                rokid.inner.Tts.TtsResponse>(
                  this, METHODID_TTS)))
          .build();
    }
  }

  /**
   */
  public static final class TtsServiceStub extends io.grpc.stub.AbstractStub<TtsServiceStub> {
    private TtsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TtsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TtsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TtsServiceStub(channel, callOptions);
    }

    /**
     */
    public void tts(rokid.inner.Tts.TtsRequest request,
        io.grpc.stub.StreamObserver<rokid.inner.Tts.TtsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_TTS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TtsServiceBlockingStub extends io.grpc.stub.AbstractStub<TtsServiceBlockingStub> {
    private TtsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TtsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TtsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TtsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<rokid.inner.Tts.TtsResponse> tts(
        rokid.inner.Tts.TtsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_TTS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TtsServiceFutureStub extends io.grpc.stub.AbstractStub<TtsServiceFutureStub> {
    private TtsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TtsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TtsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TtsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TtsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TtsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TTS:
          serviceImpl.tts((rokid.inner.Tts.TtsRequest) request,
              (io.grpc.stub.StreamObserver<rokid.inner.Tts.TtsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class TtsServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rokid.inner.Tts.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TtsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TtsServiceDescriptorSupplier())
              .addMethod(METHOD_TTS)
              .build();
        }
      }
    }
    return result;
  }
}
