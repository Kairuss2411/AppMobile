package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {

    ListView lsvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        lsvUser= findViewById(R.id.lsvUser);

        UserAdapter adapter = new UserAdapter(this, 0, ListUser());

        lsvUser.setAdapter(adapter);
    }

    public static ArrayList<User> ListUser(){

        ArrayList<User> arr = new ArrayList<>();

        arr.add(new User("Nguyễn","Đạt","09312488","abc@gmail.com","User","user1",1, "1"));
        arr.add(new User("Lê","Vinh","3429489","abc@gmail.com","User","user2",2, "2"));
        arr.add(new User("Trần","Thái","4329482","abc@gmail.com","Operator","operator1",3, "1"));
        arr.add(new User("Đinh","Liễu","90234082","abc@gmail.com","Operator","operator2",4, "2"));
        arr.add(new User("Thái","Vũ","4238832","abc@gmail.com","Manager","manager1",5, "1"));
        arr.add(new User("Lê","Vân","4238832","abc@gmail.com","Manager","manager1",5, "1"));
        arr.add(new User("Nguyễn Đăng","Khoa","4238832","abc@gmail.com","Manager","khoa123",5, "0913668886"));

        return arr;
    }

}