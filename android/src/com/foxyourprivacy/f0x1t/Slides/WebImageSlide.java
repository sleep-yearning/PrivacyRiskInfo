package com.foxyourprivacy.f0x1t.Slides;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.foxyourprivacy.f0x1t.AsyncTasks.DownloadImageTask;
import com.foxyourprivacy.f0x1t.R;

/**
 * Created by Tim on 25.06.2016.
 */
public class WebImageSlide extends Slide {
    View view;

    /* fills the slide's layout by calling fillLayout
     *@author Tim
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.layout_slide_web_image, container, false);
        fillLayout();
        return view;
    }


    /**
     * fills the slide's layout
     *
     * @author Tim
     */
    @Override
    public void fillLayout() {


        ImageView image = (ImageView) view.findViewById(R.id.image_web);
        String imageName = parameter.get("text");
        Log.d("MyApp", imageName);
        switch (imageName) {
            case "https://www.deepdotweb.com/wp-content/uploads/2015/06/deep-web-300x1971.jpg": {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.mipmap.lection_image_deepweb_1));
                break;
            }
            case "http://www.hilfe-im-netz.com/wp-content/uploads/2013/09/gmx-passwort-vergessen.jpg": {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.mipmap.lection_image_passwort_passwort));
                break;
            }
            case "http://www.puravidamultimedia.com/wp-content/uploads/2014/04/funny-password-meme-6.jpg": {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.mipmap.lection_image_password_meme));
                break;
            }
            case "http://www.wordstream.com/images/difficult-captcha.jpg": {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.mipmap.lection_image_passwort_captcha));
                break;
            }
            case "https://de.toonpool.com/user/65/files/datenschutz_2076665.jpg": {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.mipmap.lection_image_facebook_1));
                break;
            }
            case "https://upload.wikimedia.org/wikipedia/commons/a/ac/Presidio-modelo2.JPG": {
                image.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.mipmap.lection_image_deepweb_1));
                break;
            }

            default:
                new DownloadImageTask((ImageView) view.findViewById(R.id.image_web)).execute(parameter.get("text"));
        }

    }


}