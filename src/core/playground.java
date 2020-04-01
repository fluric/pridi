package core;

import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;

public class playground {
    public static void main(String[] args) {
        Tensor tensor = Tensors.of(Tensors.vector(1, 2), Tensors.vector(1, 2));
        tensor = tensor.stream().reduce(Tensor::add).get();
        System.out.print(tensor);
    }
}
