package org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.interfaces.Validable;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * @author Ruben Bermudez
 * @version 7.0
 *
 * This object defines the criteria used to request suitable users.
 * The identifiers of the selected users will be shared with the bot when the corresponding button is pressed.
 *
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyboardButtonRequestUsers implements Validable, BotApiObject {

    private static final String REQUEST_ID_FIELD = "request_id";
    private static final String USER_IS_BOT_FIELD = "user_is_bot";
    private static final String USER_IS_PREMIUM_FIELD = "user_is_premium";
    private static final String MAX_QUANTITY_FIELD = "max_quantity";
    private static final String REQUEST_NAME_FIELD = "request_name";
    private static final String REQUEST_USERNAME_FIELD = "request_username";
    private static final String REQUEST_PHOTO_FIELD = "request_photo";

    /**
     * Signed 32-bit identifier of the request that will be received back in the UsersShared object.
     * Must be unique within the message
     */
    @JsonProperty(REQUEST_ID_FIELD)
    @NonNull
    private String requestId;
    /**
     * Optional.
     * Pass True to request bots, pass False to request regular users.
     * If not specified, no additional restrictions are applied.
     */
    @JsonProperty(USER_IS_BOT_FIELD)
    private Boolean userIsBot;
    /**
     * Optional.
     * Pass True to request premium users, pass False to request non-premium users.
     * If not specified, no additional restrictions are applied.
     */
    @JsonProperty(USER_IS_PREMIUM_FIELD)
    private Boolean userIsPremium;
    /**
     * Optional.
     * The maximum number of users to be selected; 1-10.
     * Defaults to 1.
     */
    @JsonProperty(MAX_QUANTITY_FIELD)
    private Integer maxQuantity;
    /**
     * Optional.
     * Pass True to request the users' first and last name
     */
    @JsonProperty(REQUEST_NAME_FIELD)
    private Boolean requestName;
    /**
     * Optional.
     * Pass True to request the users' username
     */
    @JsonProperty(REQUEST_USERNAME_FIELD)
    private Boolean requestUsername;
    /**
     * Optional.
     * Pass True to request the users' photo
     */
    @JsonProperty(REQUEST_PHOTO_FIELD)
    private Boolean requestPhoto;

    @Override
    public void validate() throws TelegramApiValidationException {
        if (requestId.isEmpty()) {
            throw new TelegramApiValidationException("Text parameter can't be empty", this);
        }
        if (maxQuantity != null && (maxQuantity < 1 || maxQuantity > 10)) {
            throw new TelegramApiValidationException("MaxQuantity parameter must be between 1 and 10", this);
        }
    }
}
