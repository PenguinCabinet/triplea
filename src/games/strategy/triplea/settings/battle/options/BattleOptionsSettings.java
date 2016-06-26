package games.strategy.triplea.settings.battle.options;

import games.strategy.triplea.settings.HasDefaults;
import games.strategy.triplea.settings.SystemPreferenceKey;
import games.strategy.triplea.settings.SystemPreferences;
import games.strategy.triplea.ui.BattleDisplay;

public class BattleOptionsSettings implements HasDefaults {

  private static final boolean DEFAULT_CONFIRM_ENEMY_CASUALTIES = false;

  public boolean confirmEnemyCasualties() {
    return SystemPreferences.get(SystemPreferenceKey.CONFIRM_ENEMY_CASUALTIES, DEFAULT_CONFIRM_ENEMY_CASUALTIES);
  }

  public void setConfirmEnemyCasualties(boolean value) {
    BattleDisplay.setFocusOnOwnCasualtiesNotification(value);
    SystemPreferences.put(SystemPreferenceKey.CONFIRM_ENEMY_CASUALTIES, value);
  }

  @Override
  public void setToDefault() {
    setConfirmEnemyCasualties(DEFAULT_CONFIRM_ENEMY_CASUALTIES);
  }
}
