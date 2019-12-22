package G20190343020289

import (
	"reflect"
	"testing"
)

func TestPreorder(t *testing.T) {
	type args struct {
		root *Node
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"1", args{&Node{
			val: 1,
			children: []Node{
				{3, []Node{
					{5, nil},
					{6, nil},
				}},
				{2, nil},
				{4, nil},
			},
		}}, []int{1, 3, 5, 6, 2, 4}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := preorder(tt.args.root); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("Preorder() = %v, want %v", got, tt.want)
			}
		})
	}
}
