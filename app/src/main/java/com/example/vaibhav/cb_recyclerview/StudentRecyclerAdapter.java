package com.example.vaibhav.cb_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vaibhav on 15-06-2017.
 */

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder> {

    ArrayList<Student> studentArrayList;
    Context context;

    @Override
    public int getItemViewType(int position) {
        Student thisStudent=studentArrayList.get(position);
        if(thisStudent.getCourse().equals("Pandora")){
            return 0;
        }
        return 1;
    }

    public StudentRecyclerAdapter(ArrayList<Student> studentArrayList, Context context) {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCourse;
        public StudentViewHolder(View itemView) {
            super(itemView);
            //encapsulated view ,  object oriented
            tvName= (TextView) itemView.findViewById(R.id.tvName);
            tvCourse= (TextView) itemView.findViewById(R.id.tvCourse);
        }
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //similar to null check used in adapter for list view , where we check if(convertView==null)
        int layoutType;
        if(viewType==0){
            layoutType=R.layout.student_layout;
        }else{
            layoutType=R.layout.student_layout_right;
        }
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(layoutType,parent,false);
        StudentViewHolder studentViewHolder=new StudentViewHolder(itemView);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student thisStudent=studentArrayList.get(position);
        holder.tvName.setText(thisStudent.getName());
        holder.tvCourse.setText(thisStudent.getCourse());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }



}
