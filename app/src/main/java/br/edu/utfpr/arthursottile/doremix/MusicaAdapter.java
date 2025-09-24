package br.edu.utfpr.arthursottile.doremix;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;


public class MusicaAdapter extends BaseAdapter {
    private final Context context;
    private final List<Musica> itens;


    public MusicaAdapter(Context context, List<Musica> itens) {
        this.context = context;
        this.itens = itens;
    }


    @Override public int getCount() { return itens.size(); }
    @Override public Musica getItem(int position) { return itens.get(position); }
    @Override public long getItemId(int position) { return position; }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.linha_lista_musica, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }


        Musica m = getItem(position);
        vh.textTitulo.setText(m.getTitulo());
        int min = m.getDuracao() / 60; int seg = m.getDuracao() % 60;
        String durFmt = String.format("%d:%02d", min, seg);
        vh.textLinha2.setText(m.getAutor() + " • Tom: " + m.getTom() + " • " + durFmt);
        return convertView;
    }

    static class ViewHolder {
        final TextView textTitulo;
        final TextView textLinha2;

        ViewHolder(View v) {
            textTitulo = v.findViewById(R.id.textTitulo);
            textLinha2 = v.findViewById(R.id.textLinha2);
        }
    }


}