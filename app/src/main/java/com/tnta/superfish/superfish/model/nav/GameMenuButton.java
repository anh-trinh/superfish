package com.tnta.superfish.superfish.model.nav;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.Element;

public class GameMenuButton extends Element {

    public GameMenuButton(Resources resources) {
        setResources(resources);
        setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.guild));
    }

}
