import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.
        NonNull
        ;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ProductViewHolder> {
    private List<Product> productList;
    private Context context;
    public ShoppingAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull

    @Override
    public ProductViewHolder onCreateViewHolder(
            @NonNull
            ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from
                        (parent.getContext()).inflate(R.layout.
                                shoppingitem_product
                        , parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull
            ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(String.
                valueOf
                        (product.getPrice()));
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}

