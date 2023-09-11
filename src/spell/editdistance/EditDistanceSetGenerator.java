package spell.editdistance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EditDistanceSetGenerator implements EditGenerator {

    @Override
    public Set<String> generate(String rootWord) {
        Set<String> editSet = new HashSet<String>();

        ArrayList<EditGenerator> generators = new ArrayList<>();
        generators.add(new AdditionEditGenerator());
        generators.add(new DeletionEditGenerator());
        generators.add(new ReplacementEditGenerator());
        generators.add(new TranspositionEditGenerator());

        for (EditGenerator generator : generators) {
            Set<String> partialEditSet = generator.generate(rootWord);
            editSet.addAll(partialEditSet);
        }

        return editSet;
    }
}
