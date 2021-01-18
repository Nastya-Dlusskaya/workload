package by.bntu.fitr.workload.util.filewriter;

import by.bntu.fitr.workload.model.Book;

import java.io.File;
import java.io.IOException;

public interface WorkloadFileWriter {
    File writeFile(Book workloadBook) throws IOException;
}
