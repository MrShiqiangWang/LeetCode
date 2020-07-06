package history.pkg201907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindMinDifference {

    public int calcMyDis(final String a, final String b) {
        final int hour = Integer.valueOf(a.substring(0, 2));
        final int minutes = Integer.valueOf(a.substring(3, 5));

        final int bhour = Integer.valueOf(b.substring(0, 2));
        final int bminutes = Integer.valueOf(b.substring(3, 5));

        final int dis = bhour * 60 + bminutes - (hour * 60 + minutes);
        return dis;

    }

    public int findMinDifference(final List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {

            @Override
            public int compare(final String o1, final String o2) {
                final char[] co1 = o1.toCharArray();
                final char[] co2 = o2.toCharArray();
                if (co1[0] < co2[0]) {
                    return -1;
                }
                else if (co1[0] > co2[0]) {
                    return 1;
                }
                else {
                    if (co1[1] < co2[1]) {
                        return -1;
                    }
                    else if (co1[1] > co2[1]) {
                        return 1;
                    }
                    else {
                        if (co1[3] < co2[3]) {
                            return -1;
                        }
                        else if (co1[3] > co2[3]) {
                            return 1;
                        }
                        else {
                            if (co1[4] < co2[4]) {
                                return -1;
                            }
                            else if (co1[4] > co2[4]) {
                                return 1;
                            }
                            else {
                                return 0;
                            }
                        }
                    }
                }
            }
        });

        final List<Integer> list = new ArrayList<>();

        for (int i = 0; i < timePoints.size() - 1; i++) {

            final int dis = this.calcMyDis(timePoints.get(i), timePoints.get(i + 1));

            list.add(dis);
        }

        final String o1 = timePoints.get(0);
        final String o2 = timePoints.get(timePoints.size() - 1);

        final int hour = Integer.valueOf(o1.substring(0, 2));
        final int minutes = Integer.valueOf(o1.substring(3, 5));

        final int bhour = Integer.valueOf(o2.substring(0, 2));
        final int bminutes = Integer.valueOf(o2.substring(3, 5));

        final int dis = hour * 60 + minutes + 60 * 24 - (bhour * 60 + bminutes);

        list.add(dis);

        Collections.sort(list);

        return list.get(0);
    }
}
