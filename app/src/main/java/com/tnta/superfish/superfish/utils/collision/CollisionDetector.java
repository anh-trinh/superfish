package com.tnta.superfish.superfish.utils.collision;

import com.tnta.superfish.superfish.model.IElement;

public class CollisionDetector implements ICollisionDetector {

    private IElement element1, element2;

    public CollisionDetector(){
    }

    public CollisionDetector(IElement element1, IElement element2){
        setElement(element1, element2);
    }

    public void setElement(IElement element1, IElement element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    @Override
    public boolean isCollision() {

        int aHalfWidthOfFistElement = element1.getImageWidth()/2;
        int aHalfWidthOfSecondElement = element2.getImageWidth()/2;
        int distanceWhenTwoElementsJustImpactOnXAxis = aHalfWidthOfFistElement + aHalfWidthOfSecondElement;

        int aHalfHeightOfFistElement = element1.getImageHeight()/2;
        int aHalfHeightOfSecondElement = element2.getImageHeight()/2;
        int distanceWhenTwoElementsJustImpactOnYAxis = aHalfHeightOfFistElement + aHalfHeightOfSecondElement;

        int currentDistanceBetweenMiddleOfTwoElementsOnXAxis = Math.abs(element1.getCoordinateXAtMiddleOfImage() - element2.getCoordinateXAtMiddleOfImage());
        int currentDistanceBetweenMiddleOfTwoElementsOnYAxis = Math.abs(element1.getCoordinateYAtMiddleOfImage() - element2.getCoordinateYAtMiddleOfImage());

        if(currentDistanceBetweenMiddleOfTwoElementsOnXAxis <= distanceWhenTwoElementsJustImpactOnXAxis
                && currentDistanceBetweenMiddleOfTwoElementsOnYAxis <= distanceWhenTwoElementsJustImpactOnYAxis) {
            return true;
        }

        return false;
    }
}
