package services;


import com.dr.grpc.userGrpc.userImplBase;
import com.dr.grpc.User.LoginRequest;
import io.grpc.stub.StreamObserver;
import  com.dr.grpc.User.APIResponse;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import com.dr.grpc.User.Empty;

public class UserService extends userImplBase {

    @Override
    public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {

        String userName = request.getUsername();
        String password = request.getPassword();

        System.out.println( userName + " --- " + password );


        APIResponse.Builder response =  APIResponse.newBuilder();

        response.setResponseCode(200);
        response.setResponseMessage("Success");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
    }

}


