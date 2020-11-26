package Server;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import services.UserService;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) {
        BindableService bindableService;
        try {
            Server server = ServerBuilder
                    .forPort(9090)
                    .addService(new UserService())
                    .addService(ProtoReflectionService.newInstance())
                    .build()
                    .start();

            System.out.println("Started at: " + server.getPort());

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //.addService(User).build().start();
    }
}
