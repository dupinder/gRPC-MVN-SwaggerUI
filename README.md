# gRPC-MVN-SwaggerUI

gRPC application with MVN protobuf plugin for Java stubs and Enabling Swagger UI for gRPC service using ProtoReflectionService

This Repo is a working gRPC application, inspired and enhanced versions of https://github.com/yrreddy0123/yrrhelp gRPCDemo and https://github.com/grpc-swagger/grpc-swagger.



# Enable Swagger UI
## Step1: Enable Reflection

Open Server.java and register one more Service 

    .addService(ProtoReflectionService.newInstance())

And your Server will look like 

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


## Step2: Run gRPC SwaggerUI Jar 

Download SwaggerUI jar from https://github.com/grpc-swagger/grpc-swagger/releases/latest/download/grpc-swagger.jar 

Run the jar like 
      
     java -jar grpc-swagger.jar
     
Or you can use following options to run the jar 

    --server.port=6565
    --service.expired.seconds=expiredSeconds
    --enable.list.service= <true/false>

Like
      
     java -jar grpc-swagger.jar --server.port=6565
     
     
     
 

