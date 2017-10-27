package zyx.importfile;

import zyx.importfile.domain.common.ImportResult;
import zyx.importfile.exception.FileImportException;

import java.io.File;
import java.io.InputStream;

/**
 * Created by stark.zhang on 2015/11/19.
 */
public abstract class FileImportor {

    public abstract ImportResult getImportResult(InputStream is, String fileName) throws FileImportException;

}
