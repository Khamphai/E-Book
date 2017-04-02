package kphai.noobswe.com.e_book;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    TextView name_book, name, nameE, isbn, location, page;
    ImageView imageBook;

    private View dimView;
    private FloatingActionMenu fam;
    private FloatingActionButton fabChoosePic, fabCamera;

    private Handler delayAction = new Handler();

    public int[] image = {
            R.drawable.ic_book_1, R.drawable.ic_book_2,
            R.drawable.ic_book_3, R.drawable.ic_book_4,
            R.drawable.ic_book_5, R.drawable.ic_book_6,
            R.drawable.ic_book_7, R.drawable.ic_book_8,
            R.drawable.ic_book_9, R.drawable.ic_book_10,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,

            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading, R.drawable.loading,
            R.drawable.loading};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String nAmeBook = intent.getStringExtra("book_name");
        String nAme = intent.getStringExtra("name");
        String type = intent.getStringExtra("type");
        String nAmeE = intent.getStringExtra("nameE");
        String ISBN = intent.getStringExtra("isbn");
        String Location = intent.getStringExtra("location");
        String pages = intent.getStringExtra("pages");
        int a = intent.getIntExtra("position", 0);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle(type.toString());

        name_book = (TextView) findViewById(R.id.name_book);
        name = (TextView) findViewById(R.id.name);
        nameE = (TextView) findViewById(R.id.nameE);
        isbn = (TextView) findViewById(R.id.isbn);
        location = (TextView) findViewById(R.id.location);
        page = (TextView) findViewById(R.id.pages);
        imageBook = (ImageView) findViewById(R.id.imageBook);

        //Toast.makeText(getApplicationContext(), "H"+s, Toast.LENGTH_LONG).show();

        imageBook.setImageBitmap(BitmapFactory.decodeResource(getResources(), image[a]));
        name_book.setText(nAmeBook.toString());
        nameE.setText(nAmeE.toString());
        name.setText(nAme.toString());
        isbn.setText(ISBN.toString());
        location.setText(Location.toString());
        page.setText(pages.toString());

        fabShare();

    }

    private void fabShare() {
        dimView = findViewById(R.id.dim_view);
        fam = (FloatingActionMenu) findViewById(R.id.fam);
        fabCamera = (FloatingActionButton) findViewById(R.id.fab_camera);
        fabChoosePic = (FloatingActionButton) findViewById(R.id.fab_choosepic);

        final int famAnimationDuration = 50;
        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean open) {
                if (open) {
                    dimView.setVisibility(View.VISIBLE);
                    dimView.animate().alpha(0.7f).setDuration(300).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            fam.getMenuIconView().animate()
                                    .alpha(0f)
                                    .setDuration(famAnimationDuration)
                                    .start();
                            delayAction.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    fam.getMenuIconView().setImageResource(R.drawable.fab_add);
                                    fam.getMenuIconView().invalidate();
                                    fam.getMenuIconView().animate()
                                            .alpha(1f)
                                            .setDuration(famAnimationDuration)
                                            .start();
                                }
                            }, famAnimationDuration);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    }).start();
                } else {
                    dimView.animate().alpha(0.0f).setDuration(300).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            delayAction.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    fam.getMenuIconView().animate()
                                            .alpha(0f)
                                            .setDuration(famAnimationDuration)
                                            .start();
                                    delayAction.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            fam.getMenuIconView().setImageResource(R.drawable.ic_share_white_24dp);
                                            fam.getMenuIconView().invalidate();
                                            fam.getMenuIconView().animate()
                                                    .alpha(1f)
                                                    .setDuration(famAnimationDuration)
                                                    .start();
                                        }
                                    }, famAnimationDuration);
                                }
                            }, 150);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            dimView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    }).start();
                }
            }
        });
        dimView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fam.close(true);
            }
        });

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onShareText();

                fam.close(true);
            }
        });
        fabChoosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onShareImage();

                fam.close(true);
            }
        });


    }

    // function Share
    public void onShareText() {
        String s1 = name_book.getText().toString();
        String s2 = nameE.getText().toString();
        String s3 = name.getText().toString();
        String s4 = isbn.getText().toString();
        String s5 = location.getText().toString();
        String s6 = page.getText().toString();

        String s7 = collapsingToolbarLayout.getTitle().toString();



        // Get access to the URI for the bitmap


            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                            "ຊື່ປຶ້ມ : " + s1 + "\n" + s2 + "\n" +
                            "ຊື່ຜູ້ແຕ່ງ : " + s3 + "\n" +
                            "ISBN : " + s4 + "\n" +
                            "ສຳນັກພິມ : " + s5 + "\n" +
                            "ຈຳນວນໜ້າ : " + s6 + "\n" +
                            "ໝວດປຶ້ມ : " + s7);

            // Launch sharing dialog for image
            startActivity(Intent.createChooser(shareIntent, "Share Text on Social"));

    } // end of Function onShareImage

    // function Share
    public void onShareImage() {

        // Get access to the URI for the bitmap
        Uri bmpUri = getLocalBitmapUri(imageBook);
        if (bmpUri != null) {
            // Construct a ShareIntent with link to image
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
            // Launch sharing dialog for image
            startActivity(Intent.createChooser(shareIntent, "Share Image on Social"));

        } else {
            Toast.makeText(getApplicationContext(), "share failed", Toast.LENGTH_SHORT).show();
        }
    } // end of Function onShareImage


    // Returns the URI path to the Bitmap displayed in specified ImageView
    public Uri getLocalBitmapUri(ImageView imageView) {
        // Extract Bitmap from ImageView drawable
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable) {
            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        } else {
            return null;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS), "lao_food" + System.currentTimeMillis() + ".png");
            file.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    } // end of Function Return getLocalBitmapUri



}
