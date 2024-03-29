package com.example.shopease;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        private List<Product> productList;
        private Context context;

        // Interface to handle item click events
        public interface OnAddItemClickListener {
            void onAddItemClick(int position);
        }

        private OnAddItemClickListener mListener;

        // Method to set click listener
        public void setOnAddItemClickListener(OnAddItemClickListener listener) {
            mListener = listener;
        }

        public ProductAdapter(List<Product> productList, Context context) {
            this.productList = productList;
            this.context = context;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
            return new ProductViewHolder(view, mListener);
        }
        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            Product product = productList.get(position);
            holder.productName.setText(product.getName());
            holder.productDescription.setText(product.getDescription());
            holder.productPrice.setText(String.valueOf(product.getPrice()));
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

        public static class ProductViewHolder extends RecyclerView.ViewHolder {
            TextView productName, productDescription, productPrice;
            Button addButton;

            public ProductViewHolder(@NonNull View itemView, final OnAddItemClickListener listener) {
                super(itemView);
                productName = itemView.findViewById(R.id.product_name);
                productDescription = itemView.findViewById(R.id.product_description);
                productPrice = itemView.findViewById(R.id.product_price);
                addButton = itemView.findViewById(R.id.add_button);

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onAddItemClick(position);
                            }
                        }
                    }
                });
            }
        }
    }

