package org.fasttrackit.domain.competitor;

import java.util.Comparator;

public class MobileComparator implements Comparator<Mobile> {


    @Override
    public int compare(Mobile o1, Mobile o2) {

        if(o1==o2)
            return 0;
        if(o1 == null)
            return -1;
        if(o2==null)
            return 1;

      return Double.compare(o1.getTotalTravelDistance(), o2.getTotalTravelDistance());
    }
}
