package data.structure;

public class BinarySearchTree {
    public Node head = null;

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertNode(int data) {
        // CASE1: 노드가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
            return;
        }
        // CASE2: Node 가 하나 이상 들어가 있을 때
        Node findNode = this.head;
        while (true) {
            // CASE2-1: 현재 Node 의 왼쪽에 Node 가 들어가야 할 때
            if (data < findNode.data) {
                if (findNode.left != null) {
                    findNode = findNode.left;
                } else {
                    findNode.left = new Node(data);
                    return;
                }
            }
            // CASE2-2: 현재 Node 의 오른쪽에 Node 가 들어가야 할 때
            else {
                if (findNode.right != null) {
                    findNode = findNode.right;
                } else {
                    findNode.right = new Node(data);
                    return;
                }
            }

        }
    }

    public Node search(int data) {
        // CASE1: Node 가 하나도 없는 경우
        if (this.head == null) {
            return null;
        }
        // CASE2: Node 가 하나 이상 있는 경우
        Node findNode = this.head;
        while (findNode != null) {
            if (data == findNode.data) {
                return findNode;
            } else if (data < findNode.data) {
                findNode = findNode.left;
            } else {
                findNode = findNode.right;
            }
        }
        return null;
    }

    public boolean delete(int data) {
        boolean searched = false;

        // 예외 케이스 1: Node 가 하나도 없을 때
        if (this.head == null) {
            return false;
        }
        // 예외 케이스 2: Node 가 단지 하나만 있고, 해당 Node 가 삭제할 Node 일 때
        if (this.head.data == data
                && this.head.left == null && this.head.right == null) {
            this.head = null;
            return true;
        }

        Node currentParentNode = this.head;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (data == currentNode.data) {
                searched = true;
                break;
            } else if (data < currentNode.data) {
                currentParentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                currentParentNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        if (!searched) {
            return false;
        }

        //** currentNode 에는 삭제할 Node, currentParentNode 에는 삭제할 노드의 부모 Node **//
        // CASE1: 삭제할 Node 가 Leaf Node 인 경우
        if (currentNode.left == null && currentNode.right == null) {
            if (data < currentParentNode.data) {
                currentParentNode.left = null;
            } else {
                currentParentNode.right = null;
            }
            return true;
        }

        // CASE2: 삭제할 Node 가 Child Node 를 한 개 가지고 있을 경우
        // CASE2-1: 삭제할 Node 가 Child Node 를 한 개 가지고 있을 경우 (왼쪽)
        if (currentNode.left != null && currentNode.right == null) {
            if (data < currentParentNode.data) {
                currentParentNode.left = currentNode.left;
            } else {
                currentParentNode.right = currentNode.left;
            }
            return true;
        }
        // CASE2-2: 삭제할 Node 가 Child Node 를 한 개 가지고 있을 경우 (오른쪽)
        if (currentNode.left == null && currentNode.right != null) {
            if (data < currentParentNode.data) {
                currentParentNode.left = currentNode.right;
            } else {
                currentParentNode.right = currentNode.right;
            }
            return true;
        }

        if (currentNode.left != null && currentNode.right != null) {
            // CASE3-1: 삭제할 Node 가 Child Node 를 두개 가지고 있고, 삭제할 Node 가 부모 Node 의 왼쪽에 있을 때
            if (data < currentParentNode.data) {
                Node changeNode = currentNode.right;
                Node changeParentNode = currentNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                //** changeNode 에는 삭제할 Node 의 오른쪽 자식 중 가장 작은 값을 가지고 있음 **//
                // CASE3-1-1: changeNode 의 Child Node 가 없을 때
                if (changeNode.right == null) {

                }
                // CASE3-1-2: changeNode 의 오른쪽 Child Node 가 있을 때
                else {

                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(1);
        bst.insertNode(2);
        bst.insertNode(3);
        Node search = bst.search(3);
    }
}