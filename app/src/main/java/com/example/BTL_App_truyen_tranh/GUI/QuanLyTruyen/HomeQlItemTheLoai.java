package com.example.BTL_App_truyen_tranh.GUI.QuanLyTruyen;

import static com.example.BTL_App_truyen_tranh.DAO.TheLoaiDAO.sua_tl;
import static com.example.BTL_App_truyen_tranh.DAO.TheLoaiDAO.xoa_tl;
import static com.example.BTL_App_truyen_tranh.GUI.QuanLyTruyen.QuanLyTheLoai.GetList;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.BTL_App_truyen_tranh.DTO.TheLoai;
import com.example.BTL_App_truyen_tranh.R;

import java.util.List;


public class HomeQlItemTheLoai extends RecyclerView.Adapter<HomeQlItemTheLoai.HomeQlItemTheLoaiHolder> {
    private List<TheLoai> listTheLoai;
    private Context context;

    public HomeQlItemTheLoai(List<TheLoai> listTheLoai, Context context) {
        this.listTheLoai = listTheLoai;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeQlItemTheLoaiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ql_tl, parent, false);
        return new HomeQlItemTheLoaiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeQlItemTheLoaiHolder holder, int position) {
        TheLoai theLoai = listTheLoai.get(position);
        holder.text_name_tl.setText(theLoai.getTenTheLoai());
        holder.image_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suaTheloai(theLoai.getId(), theLoai.getTenTheLoai());
            }
        });
        holder.image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoaTheloai(theLoai.getId());
            }
        });
    }

    private void suaTheloai(int id, String tenTheLoai) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_tl);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        window.setAttributes(layoutParams);
        dialog.setCancelable(true);

        EditText edit_addtl = dialog.findViewById(R.id.edit_addtl);
        TextView text_view = dialog.findViewById(R.id.text_view);
        Button button_huy = dialog.findViewById(R.id.button_huy);
        Button button_them = dialog.findViewById(R.id.button_them);
        text_view.setText("S???a th??? lo???i");
        button_them.setText("S???a");
        edit_addtl.setText(tenTheLoai);
        button_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tentl = edit_addtl.getText().toString().trim();
                if (tentl.isEmpty()) {
                    Toast.makeText(dialog.getContext(), "Vui l??ng nh???p t??n th??? lo???i!", Toast.LENGTH_SHORT).show();
                } else {
                    if (sua_tl(id, tentl)) {
                        Toast.makeText(dialog.getContext(), "S???a th??nh c??ng!", Toast.LENGTH_SHORT).show();
                        GetList(context);
                        dialog.dismiss();
                    }
                }
            }
        });
        button_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    private void xoaTheloai(int ids) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("B???n c?? mu???n x??a th??? lo???i n??y kh??ng!")
                .setPositiveButton("X??a", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (xoa_tl(ids)) {
                            GetList(context);
                            Toast.makeText(context, "X??a th??nh c??ng", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(context, "X??a th???t b???i", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("H???y", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        builder.create();
        builder.show();
    }

    ;

    @Override
    public int getItemCount() {
        if (listTheLoai != null) {
            return listTheLoai.size();
        }
        return 0;
    }

    public class HomeQlItemTheLoaiHolder extends RecyclerView.ViewHolder {
        private TextView text_name_tl;
        private ImageView image_edit, image_delete;

        public HomeQlItemTheLoaiHolder(@NonNull View itemView) {
            super(itemView);
            text_name_tl = itemView.findViewById(R.id.text_name_tl);
            image_edit = itemView.findViewById(R.id.image_edit);
            image_delete = itemView.findViewById(R.id.image_delete);
        }
    }
}
