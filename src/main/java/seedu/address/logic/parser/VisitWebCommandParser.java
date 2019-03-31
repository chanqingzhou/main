package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.VisitWebCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.restaurant.Weblink;

/**
 * Parses input arguments and creates a new VisitWebCommand object
 */
public class VisitWebCommandParser implements Parser<VisitWebCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the VisitWebCommand
     * and returns an VisitWebCommand object for execution.
     * Expects an index
     * @throws ParseException if the user input does not conform the expected format
     */
    public VisitWebCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new VisitWebCommand(index);
        } catch (ParseException pe) {
            return parseUrl(args);
        }
    }

    /**
     * Parses the given {@code String} of arguments in the context of the VisitWebCommand
     * and returns an VisitWebCommand object for execution.
     * Expects a weblink
     * @throws ParseException if the user input does not conform the expected format
     */
    private VisitWebCommand parseUrl(String args) throws ParseException {
        Weblink weblink = ParserUtil.parseWeblink(args);
        return new VisitWebCommand(weblink);
    }
}
