public final class Animation {

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = new Stream(streamLoader.getDataForName("seq.dat"));
		int length = stream.readUnsignedWord();
		System.out.println("Anim length: " + length);
		if (anims == null)
			anims = new Animation[length];
		for (int j = 0; j < length; j++) {
			if (anims[j] == null)
				anims[j] = new Animation();
			anims[j].readValues(stream);
			
			
			
			switch(j) {
			case 5068:
				//fileID: 182
				anims[5068] = new Animation();
				anims[5068].anInt352 = 36;
				anims[5068].anInt356 = -1;
				anims[5068].anInt359 = 6;
				anims[5068].anInt360 = -1;
				anims[5068].anInt361 = -1;
				anims[5068].anInt362 = 99;
				anims[5068].anInt363 = 0;
				anims[5068].anInt364 = 0;
				anims[5068].anInt365 = 1;
				anims[5068].aBoolean358 = false;
				anims[5068].anIntArray353 = new int[] {11927613, 11927599, 11927574, 11927659, 11927676, 11927562, 11927626, 11927628, 11927684, 11927647, 11927602, 11927576, 11927586, 11927653, 11927616, 11927653, 11927586, 11927576, 11927602, 11927576, 11927586, 11927653, 11927616, 11927653, 11927586, 11927576, 11927602, 11927576, 11927586, 11927653, 11927616, 11927653, 11927586, 11927576, 11927554, 11927602};
				anims[5068].anIntArray355 = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
				break;
				case 5069:
				//fileID: 182
				anims[5069] = new Animation();
				anims[5069].anInt352 = 15;
				anims[5069].anInt356 = -1;
				anims[5069].anInt359 = 6;
				anims[5069].anInt360 = -1;
				anims[5069].anInt361 = -1;
				anims[5069].anInt362 = 99;
				anims[5069].anInt363 = 0;
				anims[5069].anInt364 = 0;
				anims[5069].anInt365 = 1;
				anims[5069].aBoolean358 = false;
				anims[5069].anIntArray353 = new int[] {11927613, 11927599, 11927574, 11927659, 11927676, 11927562, 11927626, 11927628, 11927684, 11927647, 11927602, 11927576, 11927586, 11927653, 11927616};
				anims[5069].anIntArray355 = new int[] {3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5};
				break;
				case 5070:
				//fileID: 182
				anims[5070] = new Animation();
				anims[5070].anInt352 = 9;
				anims[5070].anInt356 = -1;
				anims[5070].anInt359 = 5;
				anims[5070].anInt360 = -1;
				anims[5070].anInt361 = -1;
				anims[5070].anInt362 = 99;
				anims[5070].anInt363 = 0;
				anims[5070].anInt364 = 0;
				anims[5070].anInt365 = 2;
				anims[5070].aBoolean358 = false;
				anims[5070].anIntArray353 = new int[] {11927608, 11927625, 11927598, 11927678, 11927582, 11927600, 11927669, 11927597, 11927678};
				anims[5070].anIntArray355 = new int[] {5, 4, 4, 4, 5, 5, 5, 4, 4};
				break;
				case 5071:
				//fileID: 182
				anims[5071] = new Animation();
				anims[5071].anInt352 = 21;
				anims[5071].anInt356 = -1;
				anims[5071].anInt359 = 9;
				anims[5071].anInt360 = -1;
				anims[5071].anInt361 = -1;
				anims[5071].anInt362 = 99;
				anims[5071].anInt363 = 0;
				anims[5071].anInt364 = 0;
				anims[5071].anInt365 = 2;
				anims[5071].aBoolean358 = false;
				anims[5071].anIntArray353 = new int[] {11927640, 11927643, 11927695, 11927630, 11927556, 11927667, 11927692, 11927588, 11927555, 11927624, 11927633, 11927673, 11927661, 11927666, 11927664, 11927579, 11927670, 11927636, 11927685, 11927595, 11927623};
				anims[5071].anIntArray355 = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
				break;
				case 5072:
				//fileID: 182
				anims[5072] = new Animation();
				anims[5072].anInt352 = 21;
				anims[5072].anInt356 = 1;
				anims[5072].anInt359 = 8;
				anims[5072].anInt360 = -1;
				anims[5072].anInt361 = -1;
				anims[5072].anInt362 = 99;
				anims[5072].anInt363 = 0;
				anims[5072].anInt364 = 0;
				anims[5072].anInt365 = 2;
				anims[5072].aBoolean358 = false;
				anims[5072].anIntArray353 = new int[] {11927623, 11927595, 11927685, 11927636, 11927670, 11927579, 11927664, 11927666, 11927661, 11927673, 11927633, 11927624, 11927555, 11927588, 11927692, 11927667, 11927556, 11927630, 11927695, 11927643, 11927640};
				anims[5072].anIntArray355 = new int[] {2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
				break;
				case 5061:
					anims[j].setDefaults();
					anims[j].anInt352 = 13;
					anims[j].anIntArray353 = new int[] { 19267601, 19267602, 19267603, 19267604, 19267605, 19267606, 19267607, 19267606, 19267605, 19267604, 19267603, 19267602, 19267601, };
					anims[j].anIntArray355 = new int[] { 4, 3, 3, 4, 10, 10, 15, 10, 10, 4, 3, 3, 4, };
					anims[j].anIntArray357 = new int[] { 1, 2, 9, 11, 13, 15, 17, 19, 37, 39, 41, 43, 45, 164, 166, 168, 170, 172, 174, 176, 178, 180, 182, 183, 185, 191, 192, 9999999, };
					anims[j].anInt359 = 6;
					anims[j].anInt360 = 0;
					anims[j].anInt361 = 13438;
					anims[j].anInt365 = 1;
				break;
				
			}
		}
	}
		

	public int method258(int i) {
		int j = anIntArray355[i];
		if (j == 0) {
			Class36 class36 = Class36.method531(anIntArray353[i]);
			if (class36 != null)
				j = anIntArray355[i] = class36.anInt636;
		}
		if (j == 0)
			j = 1;
		return j;
	}

	public void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				break;
			if (i == 1) {
				anInt352 = stream.readUnsignedWord();
				anIntArray353 = new int[anInt352];
				anIntArray354 = new int[anInt352];
				anIntArray355 = new int[anInt352];
				for (int j = 0; j < anInt352; j++) {
					anIntArray355[j] = stream.readUnsignedWord();
					anIntArray354[j] = -1;
				}
				for (int j = 0; j < anInt352; j++)
					anIntArray353[j] = stream.readUnsignedWord();
				for (int i1 = 0; i1 < anInt352; i1++) {
					anIntArray353[i1] = (stream.readUnsignedWord() << 16)
							+ anIntArray353[i1];
				}
			} else if (i == 2)
				anInt356 = stream.readUnsignedWord();
			else if (i == 3) {
				int k = stream.readUnsignedByte();
				anIntArray357 = new int[k + 1];
				for (int l = 0; l < k; l++)
					anIntArray357[l] = stream.readUnsignedByte();

				anIntArray357[k] = 0x98967f;
			} else if (i == 4)
				aBoolean358 = true;
			else if (i == 5)
				anInt359 = stream.readUnsignedByte();
			else if (i == 6)
				anInt360 = stream.readUnsignedWord();
			else if (i == 7)
				anInt361 = stream.readUnsignedWord();
			else if (i == 8)
				anInt362 = stream.readUnsignedByte();
			else if (i == 9)
				anInt363 = stream.readUnsignedByte();
			else if (i == 10)
				anInt364 = stream.readUnsignedByte();
			else if (i == 11)
				anInt365 = stream.readUnsignedByte();
			else if (i == 12)
				stream.readDWord();
			else
				System.out.println("Error unrecognised seq config code: " + i);
		} while (true);
		if (anInt352 == 0) {
			anInt352 = 1;
			anIntArray353 = new int[1];
			anIntArray353[0] = -1;
			anIntArray354 = new int[1];
			anIntArray354[0] = -1;
			anIntArray355 = new int[1];
			anIntArray355[0] = -1;
		}
		if (anInt363 == -1)
			if (anIntArray357 != null)
				anInt363 = 2;
			else
				anInt363 = 0;
		if (anInt364 == -1) {
			if (anIntArray357 != null) {
				anInt364 = 2;
				return;
			}
			anInt364 = 0;
		}
	}

	public Animation() {
		anInt356 = -1;
		aBoolean358 = false;
		anInt359 = 5;
		anInt360 = -1;
		anInt361 = -1;
		anInt362 = 99;
		anInt363 = -1;
		anInt364 = -1;
		anInt365 = 2;
	}
	
	private void setDefaults() {
		anInt356 = -1;
		aBoolean358 = false;
		anInt359 = 5;
		anInt360 = -1;
		anInt361 = -1;
		anInt362 = 99;
		anInt363 = -1;
		anInt364 = -1;
		anInt365 = 2;
	}

	public static Animation anims[];
	public int anInt352;
	public int anIntArray353[];
	public int anIntArray354[];
	public int[] anIntArray355;
	public int anInt356;
	public int anIntArray357[];
	public boolean aBoolean358;
	public int anInt359;
	public int anInt360;
	public int anInt361;
	public int anInt362;
	public int anInt363;
	public int anInt364;
	public int anInt365;
	public static int anInt367;
}
