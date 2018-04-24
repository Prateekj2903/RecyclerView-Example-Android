package com.example.windo.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


// Add Dependencies
// Replace Recycler View in layout and give it some id
// Add layout file for item and add a text view with some id
// Make an adapter class and extend the class to RecyclerView.Adapter<ExampleAdapter.ExampleAdapterViewHolder>
// Make a class inside ExampleAdapter named ExampleAdapterViewHolder and extend the class to RecyclerView.ViewHolder
// Make a reference of the item layout text view inside the inner class and in the constructor that accepts View as a param
// Call super(view) inside the constructor and use view.findViewById() to assign the text view for item and save it to the reference created
// make a bind method inside this class that takes integer as an argument and set text to the reference of text view
//Override onCreateViewHolder inside the adapter class...
//Get the context by parent.getContext() and main layout using R.layout.layout_name for item layout
//Create a LayoutInflater by LayoutInflater.from(context)
//make shouldAttachToParentImmediately false
//Create a View using inflater.inflate and pass layoutId, parent ViewGroup and shouldAttachToParentImmediately
//Create a new object of the inner class and pass the view as a parameter
//Return the object
//override onBindViewHolder
//call the bind method and pass the position in as a parameter
//override the getItemCount method and return the length
//Make a function in the adapter class that sets the private variable and call the notifyDataSetChanged() method
//In MainActivity make a LinearLayoutManager and set it on the Recycler View reference
//Make object of ExampleAdapter and set it on the reference
//Call the ExampleAdapter fun and pass the data in it


/*
OnClick Listener :

1. Add an interface ExampleAdapterClickHandler in the Adapter class
2. Within that interface, define a void method that access a String as a parameter
3. Create a final private ExampleAdapterOnClickHandler in the adapter class
4. Add a ExampleAdapterClickHandler object as a parameter in the adapter class and assign its value to the variable made in prev step
5. Implement the OnClickListener in the ExampleAdapterViewHandler class inside ExampleAdapter class
6. override the onclick method inside this inner class and get the current adapter pos by getAdapterPosition() and call the method in the interface via the interface reference
    and pass the string at the adapter position in the parameter
7. Inside the constructor of the inner class....call setOnClickListener on the view passed via the constructor.

8. Implement this ExampleAdapterOnClickListener in MainActivity
9. override the onClick method and show a toast with the current item as text
10. pass the context(this) while making the object of ExampleAdapter class.

 */


public class MainActivity extends AppCompatActivity implements ExampleAdapter.ExampleAdapterOnClickListener{

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_example);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        ExampleAdapter exampleAdapter = new ExampleAdapter(this);

        mRecyclerView.setAdapter(exampleAdapter);

        String []t = new String[100];
        for(int i = 0 ; i < 100; i++){
            t[i] = String.valueOf(i);
        }
        exampleAdapter.setText(t);

    }

    @Override
    public void onClick(String currText) {
        Toast.makeText(this, currText, Toast.LENGTH_SHORT).show();
    }
}
