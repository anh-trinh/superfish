package com.tnta.superfish.superfish.controller.nav;

import com.tnta.superfish.superfish.GamePanelBackup;
import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.nav.Energy;

public class EnergyController extends ElementController implements IElementController {

    private Energy energy = new Energy(getResources());

    public Energy getEnergy() {
        return energy;
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
        setElement(this.energy);
    }

    @Override
    public void doDraw() {
        getEnergy().setEnergyType(GamePanelBackup.energyLevel);
        getEnergy().updateImageBitmap();
        getEnergy().setCoordinateX(getCanvas().getWidth() / 24);
        getEnergy().setCoordinateY(2 * getEnergy().getImageBitmap().getHeight());
        setElement(getEnergy());
        doDrawElement();
    }
}
