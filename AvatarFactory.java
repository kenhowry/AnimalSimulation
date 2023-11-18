package hw3;

public class AvatarFactory {

	public static Avatar newAvatar(String avaName, TerrainMap tm, GridPoint loc) throws BadAvatarException {
		switch (avaName) {
		case "goat":
			return new Goat(tm, loc);
		case "platypus":
			return new Platypus(tm, loc);
		case "duck":
			return new Duck(tm, loc);
		case "otter":
			return new Otter(tm, loc);
		case "human":
			return new Human(tm, loc);
		default: 
			throw new BadAvatarException("Invalid avater type.");
		}

	}

}
