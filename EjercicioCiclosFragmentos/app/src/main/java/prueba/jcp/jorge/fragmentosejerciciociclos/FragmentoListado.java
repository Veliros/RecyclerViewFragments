package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link FragmentoListado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoListado extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String LISTADO_FINAL = "listado final";

    // TODO: Rename and change types of parameters
    private ArrayList<CicleFlorida> listadoRecibidoPorParametros;
    private TextView tvListado;
    //private OnFragmentInteractionListener mListener;

    public FragmentoListado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentoListado.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoListado newInstance(ArrayList<CicleFlorida> listadoFinal) {
        FragmentoListado fragment = new FragmentoListado();
        Bundle args = new Bundle();
        args.putParcelableArrayList(LISTADO_FINAL, listadoFinal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listadoRecibidoPorParametros = getArguments().getParcelableArrayList(LISTADO_FINAL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String textoAMostrar=new String("");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_listado, container, false);

        tvListado = v.findViewById(R.id.etListado);
        for(CicleFlorida elElemento: listadoRecibidoPorParametros){
            textoAMostrar=textoAMostrar+elElemento.getTitol()+"\n"+elElemento.getDescripcio()+"\n";

        }
        tvListado.setText(textoAMostrar);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    /*
    public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
     */

}
