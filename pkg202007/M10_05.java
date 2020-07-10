package pkg202007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class M10_05 {
	private static class Node {
		int index;
		String str;

		Node(int index, String str) {
			this.index = index;
			this.str = str;
		}
	}

	public int findString(String[] words, String s) {
		List<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals("")) {
				nodes.add(new Node(i, words[i]));
			}
		}
		return Collections.binarySearch(nodes, new Node(0, s), new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.str.compareTo(o2.str);
			}
		});
	}
}
