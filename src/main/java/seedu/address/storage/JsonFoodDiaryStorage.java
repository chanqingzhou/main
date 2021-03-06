package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyFoodDiary;

/**
 * A class to access FoodDiary data stored as a json file on the hard disk.
 */
public class JsonFoodDiaryStorage implements FoodDiaryStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonFoodDiaryStorage.class);

    private Path filePath;

    public JsonFoodDiaryStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getFoodDiaryFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyFoodDiary> readFoodDiary() throws DataConversionException {
        return readFoodDiary(filePath);
    }

    /**
     * Similar to {@link #readFoodDiary()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyFoodDiary> readFoodDiary(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableFoodDiary> jsonFoodDiary = JsonUtil.readJsonFile(
                filePath, JsonSerializableFoodDiary.class);
        if (!jsonFoodDiary.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonFoodDiary.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveFoodDiary(ReadOnlyFoodDiary foodDiary) throws IOException {
        saveFoodDiary(foodDiary, filePath);
    }

    /**
     * Similar to {@link #saveFoodDiary(ReadOnlyFoodDiary)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveFoodDiary(ReadOnlyFoodDiary foodDiary, Path filePath) throws IOException {
        requireNonNull(foodDiary);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableFoodDiary(foodDiary), filePath);
    }

}
