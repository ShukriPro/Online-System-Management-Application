package com.example.osmsv2.view;

import android.content.Context;
import android.content.Intent; // Ensure this import for Intent to work
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.osmsv2.R;
import com.example.osmsv2.model.data.Customer;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> customerList;
    private Context context;

    public CustomerAdapter(Context context, List<Customer> customerList) {
        this.context = context;
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_item, parent, false);
        return new CustomerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer currentCustomer = customerList.get(position);
        holder.tvCustomerId.setText("ID: " + currentCustomer.getCustomerID());
        holder.tvCustomerName.setText("Name: " + currentCustomer.getCustomerFirstName());
        holder.tvRegisteredDate.setText("Registered: " + currentCustomer.getCustomerRegistrationDate());
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView tvCustomerId, tvCustomerName, tvRegisteredDate;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCustomerId = itemView.findViewById(R.id.tvCustomerId);
            tvCustomerName = itemView.findViewById(R.id.tvCustomerName);
            tvRegisteredDate = itemView.findViewById(R.id.tvRegisteredDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public void setCustomers(List<Customer> customers) {
        this.customerList = customers;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public Customer getCustomerAtPosition(int position) {
        return customerList.get(position);
    }

}
