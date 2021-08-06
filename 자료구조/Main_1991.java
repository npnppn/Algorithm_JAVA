package data_structure;

import java.io.*;
import java.util.*;
//한번 더 풀어보기

class NodeT {
	char data;
	NodeT left;
	NodeT right;

	NodeT(char data) {
		this.data = data;
	}
}

public class Main_1991 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		for (int tc = 0; tc < n; tc++) {
			st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.insert(node, left, right);
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}

}

class Tree {
	NodeT root;

	// root가 없으면 입력받은 NodeT를 root로 지정 후 리턴
	// root가 존재한다면, 트리 탐색을 진행해서 적절한 위치에 삽입
	void insert(char data, char leftData, char rightData) {
		if (root == null) {
			if (data != '.')
				root = new NodeT(data);
			if (leftData != '.')
				root.left = new NodeT(leftData);
			if (rightData != '.')
				root.right = new NodeT(rightData);
		} else {
			search(root, data, leftData, rightData);
		}
	}

	// 해당 data가 위치하는 곳(data가 서브트리의 root가 되는 위치)을 찾아 삽입
	void search(NodeT root, char data, char leftData, char rightData) {
		if (root == null)
			return;
		if (root.data == data) {
			if (leftData != '.')
				root.left = new NodeT(leftData);
			if (rightData != '.')
				root.right = new NodeT(rightData);
		} else {
			search(root.left, data, leftData, rightData);
			search(root.right, data, leftData, rightData);
		}
	}

	// 루트 -> 왼쪽-> 오른쪽
	void preOrder(NodeT root) {
		System.out.print(root.data);
		if (root.left != null)
			preOrder(root.left);
		if (root.right != null)
			preOrder(root.right);
	}

	// 왼쪽-> 루트-> 오른쪽
	void inOrder(NodeT root) {
		if (root.left != null)
			inOrder(root.left);
		System.out.print(root.data);
		if (root.right != null)
			inOrder(root.right);
	}

	// 왼쪽-> 오른쪽-> 루트
	void postOrder(NodeT root) {
		if (root.left != null)
			postOrder(root.left);
		if (root.right != null)
			postOrder(root.right);
		System.out.print(root.data);
	}
}