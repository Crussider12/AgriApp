package agri.app.wishlistFragmentModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agri.app.R;


public class WishlistFragment extends Fragment {
    View view;

    public static WishlistFragment newInstance() {
        WishlistFragment wishlistFragment = new WishlistFragment();
        return wishlistFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        return view;
    }
}
