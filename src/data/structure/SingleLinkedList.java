package data.structure;

public class SingleLinkedList<T> {
    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(head.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data) {
        if (this.head != null) {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    /**
     * 두번 째 파라미터의 뒤에 노드를 삽입하는 메서드
     * @param data 삽입할 데이터
     * @param isData 삽입할 데이터의 앞 노드의 값
     */
    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) { // 삽일할 노드가 없을 경우
            this.addNode(data); // 링크드 리스트의 맨 뒤에 삽입
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<>(data);
            searchedNode.next.next = nextNode;
        }
    }

    /**
     *
     * @param isData
     * @return 데이터가 삭제 되었다면 true, 아니라면 false 리턴
     */
    public boolean delNode(T isData) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if (node.data == isData) { // 삭제할 데이터가 head 일 경우
                this.head = head.next;
                return true;
            }
            else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

}
