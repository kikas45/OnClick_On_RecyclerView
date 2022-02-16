package com.example.recyclerview_intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapater_ViewHolder> {
    // declaring the list of data
    private  List<UserModel> userModelList;
    private Context mcontext;
    private Selecteduser selecteduser;

    public UserAdapter(List<UserModel> userModelList, Selecteduser selecteduser) {
        this.userModelList = userModelList;
        this.selecteduser = selecteduser;
    }

    @NonNull
    @Override
    public UserAdapter.UserAdapater_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

/*        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_users, parent, false);
        return new UserAdapter.UserAdapater_ViewHolder(view);*/

        mcontext = parent.getContext();
        return  new UserAdapater_ViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.row_users, null));

    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserAdapater_ViewHolder holder, int position) {

    UserModel userModel = userModelList.get(position);

       String usernmae = userModel.getUsername();
       String prefix = userModel.getUsername().substring(0,1);

       // it si very important to use the holder to old them after calling the "usermodelist" and arranged
        // them into position
        // the holder will call the "View holder items and fixed them "
        holder.username.setText(prefix);
        holder.pretextview.setText(usernmae);

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public  interface Selecteduser{
        void selecteduser(UserModel userModel);
    }

    public class UserAdapater_ViewHolder extends RecyclerView.ViewHolder {
         TextView pretextview;
         TextView username;
         ImageView imicon;

        public UserAdapater_ViewHolder(@NonNull View itemView) {
            super(itemView);

            pretextview = itemView.findViewById(R.id.prefix);
            username = itemView.findViewById(R.id.username);
            imicon = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    selecteduser.selecteduser(userModelList.get(getAdapterPosition()));

                }
            });
        }
    }
}
