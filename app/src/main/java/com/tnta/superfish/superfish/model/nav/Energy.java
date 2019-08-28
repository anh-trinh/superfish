package com.tnta.superfish.superfish.model.nav;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.Element;

public class Energy extends Element {

    int[] energyStates = {R.drawable.energy0, R.drawable.energy1, R.drawable.energy2,
            R.drawable.energy3, R.drawable.energy4, R.drawable.energy5,
            R.drawable.energy6, R.drawable.energy7, R.drawable.energy8,
            R.drawable.energy9, R.drawable.energy10, R.drawable.energy11, R.drawable.energy12,
            R.drawable.energy13, R.drawable.energy14, R.drawable.energy15, R.drawable.energy16,
            R.drawable.energy17, R.drawable.energy18, R.drawable.energy19, R.drawable.energy20, R.drawable.energy21,
            R.drawable.energy22, R.drawable.energy23, R.drawable.energy24, R.drawable.energy25, R.drawable.energy26,
            R.drawable.energy27, R.drawable.energy28, R.drawable.energy29, R.drawable.energy30, R.drawable.energy31,
            R.drawable.energy32, R.drawable.energy33, R.drawable.energy34, R.drawable.energy35, R.drawable.energy36, R.drawable.energy37, R.drawable.energy38, R.drawable.energy39,
            R.drawable.energy40, R.drawable.energy41, R.drawable.energy42, R.drawable.energy43, R.drawable.energy44, R.drawable.energy45, R.drawable.energy46, R.drawable.energy47, R.drawable.energy48, R.drawable.energy49,
            R.drawable.energy50, R.drawable.energy51, R.drawable.energy52, R.drawable.energy53, R.drawable.energy54, R.drawable.energy55, R.drawable.energy56, R.drawable.energy57, R.drawable.energy58, R.drawable.energy59,
            R.drawable.energy60, R.drawable.energy61, R.drawable.energy62, R.drawable.energy63, R.drawable.energy64, R.drawable.energy65, R.drawable.energy66, R.drawable.energy67, R.drawable.energy68, R.drawable.energy69,
            R.drawable.energy70, R.drawable.energy71, R.drawable.energy72, R.drawable.energy73, R.drawable.energy74, R.drawable.energy75, R.drawable.energy76, R.drawable.energy77, R.drawable.energy78, R.drawable.energy79,
            R.drawable.energy80, R.drawable.energy81, R.drawable.energy82, R.drawable.energy83, R.drawable.energy84, R.drawable.energy85, R.drawable.energy86, R.drawable.energy87, R.drawable.energy88, R.drawable.energy89,
            R.drawable.energy90, R.drawable.energy91};

    private int energyType;

    public Energy(Resources resources) {
        setResources(resources);
    }

    public int getEnergyType() {
        return energyType;
    }

    public void setEnergyType(int energyType) {
        this.energyType = energyType;
    }

    public void updateImageBitmap() {
        setImageBitmap(BitmapFactory.decodeResource(getResources(), energyStates[getEnergyType()]));
    }
}
