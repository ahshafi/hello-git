package Pkg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws Exception {
        // write your code here
//        String json =
//                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            List<Car> list=new ArrayList<>();
            list.add(new Car("Mercedes",5));
            list.add(new Car("BMW",3));
            String json = objectMapper.writeValueAsString(list);
            FileWriter fos=new FileWriter("manufacturers.json");
            fos.write(json);
            fos.close();
            //Car car = objectMapper.readValue(json, Car.class);
            List<Car> cars1 = objectMapper.readValue(json, new TypeReference<List<Car>>(){});
            for(int i=0;i<cars1.size();i++)
                System.out.println(cars1.get(i).getBrand());
            //System.out.println("car brand = " + car.getBrand());
            //System.out.println("car doors = " + car.getDoors());
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        String carJson =
//                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
//
//        try {
//            Car car = objectMapper.readValue(carJson, Car.class);
//
//            System.out.println("car brand = " + car.getBrand());
//            System.out.println("car doors = " + car.getDoors());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}