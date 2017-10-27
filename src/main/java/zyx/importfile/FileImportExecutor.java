package zyx.importfile;

import zyx.importfile.domain.common.Configuration;
import zyx.importfile.domain.common.ImportResult;
import zyx.importfile.exception.FileImportException;
import zyx.importfile.impl.ExcelImportor;

import java.io.File;
import java.io.InputStream;

/**
 * Created by stark.zhang on 2015/11/28.
 */
public class FileImportExecutor {

    public static ImportResult importFile(Configuration configuration, InputStream is, String fileName) throws FileImportException{
        FileImportor fileImportor = getFileImportor(configuration);
        return fileImportor.getImportResult(is, fileName);
    }

    /**
     * 根据configuration里面 imporFileType返回
     * 默认 返回 ExcelImportor
     * @param configuration
     * @return
     */
    private static FileImportor getFileImportor(Configuration configuration) throws FileImportException {
        if (configuration.getImportFileType() == Configuration.ImportFileType.EXCEL) {
            return new ExcelImportor(configuration);
        }
        throw new FileImportException("Can not find Importor. Please check importFileType in configuration");
    }
}
