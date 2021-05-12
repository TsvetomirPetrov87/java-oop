package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

public abstract class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {

        Collection<Player> counterTerrorists = players.stream()
                .filter(c -> c instanceof CounterTerrorist)
                .collect(Collectors.toList());

        Collection<Player> terrorists = players.stream()
                .filter(c -> c instanceof Terrorist)
                .collect(Collectors.toList());

        while (counterTerrorists.stream().anyMatch(Player::isAlive) && terrorists.stream().anyMatch(Player::isAlive)) {
            for (Player terrorist : terrorists) {
                for (Player counterTerrorist : counterTerrorists) {
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }
            counterTerrorists = counterTerrorists.stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toList());

            for (Player counterTerrorist : counterTerrorists) {
                for (Player terrorist : terrorists) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }

            terrorists = terrorists.stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toList());
        }
        if (terrorists.stream().anyMatch(Player::isAlive)) {
            return String.format(TERRORIST_WINS);
        }
        return String.format(COUNTER_TERRORIST_WINS);
    }
}
