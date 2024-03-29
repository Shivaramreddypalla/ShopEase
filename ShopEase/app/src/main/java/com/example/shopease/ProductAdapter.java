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
}
