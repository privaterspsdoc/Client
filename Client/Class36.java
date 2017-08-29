public final class Class36 {

	public static java.util.Hashtable<Integer, Class36> frameList = new java.util.Hashtable<Integer, Class36>();

	 

		public static void loadOSRS(byte abyte0[], int fileId) {
			  final Stream stream_1 = new Stream(abyte0);
              final Class18 class18 = new Class18(stream_1, true);
              final int k1 = stream_1.readUnsignedWord();;
              	
			int ai[] = new int[500];
			int ai1[] = new int[500];
			int ai2[] = new int[500];
			int ai3[] = new int[500];
			for (int l1 = 0; l1 < k1; l1++) {
				int i2 = stream_1.readUnsignedWord();
				Class36 class36 = new Class36();
				frameList.put(new Integer((fileId << 16) + i2), class36);
				class36.aClass18_637 = class18;
				int j2 = stream_1.readUnsignedByte();
				int k2 = -1;
				int l2 = 0;
				for (int i3 = 0; i3 < j2; i3++) {
					int j3 = stream_1.readUnsignedByte();
					if (j3 > 0) {
						if (class18.anIntArray342[i3] != 0) {
							for (int l3 = i3 - 1; l3 > k2; l3--) {
								if (class18.anIntArray342[l3] != 0)
									continue;
								ai[l2] = l3;
								ai1[l2] = 0;
								ai2[l2] = 0;
								ai3[l2] = 0;
								l2++;
								break;
							}

						}
						ai[l2] = i3;
						char c = '\0';
						if (class18.anIntArray342[i3] == 3)
							c = '\200';
						if ((j3 & 1) != 0)
							ai1[l2] = stream_1.readShort2();
						else
							ai1[l2] = c;
						if ((j3 & 2) != 0)
							ai2[l2] = stream_1.readShort2();
						else
							ai2[l2] = c;
						if ((j3 & 4) != 0)
							ai3[l2] = stream_1.readShort2();
						else
							ai3[l2] = c;
						k2 = i3;
						l2++;
					}
				}

				class36.stepCount = l2;
				class36.opcodeLinkTable = new int[l2];
				class36.modifier1 = new int[l2];
				class36.modifier2 = new int[l2];
				class36.modifier3 = new int[l2];
				for (int k3 = 0; k3 < l2; k3++) {
					class36.opcodeLinkTable[k3] = ai[k3];
					class36.modifier1[k3] = ai1[k3];
					class36.modifier2[k3] = ai2[k3];
					class36.modifier3[k3] = ai3[k3];
				}

			}

		}
	
	public static void load(byte abyte0[], int fileId) {
		if (fileId == 182) {
			loadOSRS(abyte0, fileId);
		}
		Stream stream = new Stream(abyte0);
		stream.currentOffset = abyte0.length - 12;
		int i = stream.readDWord();
		int j = stream.readDWord();
		int k = stream.readDWord();
		int i1 = 0;
		Stream stream_1 = new Stream(abyte0);
		stream_1.currentOffset = i1;
		i1 += i + 4;
		Stream stream_2 = new Stream(abyte0);
		stream_2.currentOffset = i1;
		i1 += j;
		Stream stream_3 = new Stream(abyte0);
		stream_3.currentOffset = i1;
		i1 += k;
		Stream stream_4 = new Stream(abyte0);
		stream_4.currentOffset = i1;
		Class18 class18 = new Class18(stream_4, false);
		int k1 = stream_1.readDWord();
		int ai[] = new int[500];
		int ai1[] = new int[500];
		int ai2[] = new int[500];
		int ai3[] = new int[500];
		for (int l1 = 0; l1 < k1; l1++) {
			int i2 = stream_1.readDWord();
			Class36 class36 = new Class36();
			frameList.put(new Integer((fileId << 16) + i2), class36);
			class36.aClass18_637 = class18;
			int j2 = stream_1.readUnsignedByte();
			int k2 = -1;
			int l2 = 0;
			for (int i3 = 0; i3 < j2; i3++) {
				int j3 = stream_2.readUnsignedByte();
				if (j3 > 0) {
					if (class18.anIntArray342[i3] != 0) {
						for (int l3 = i3 - 1; l3 > k2; l3--) {
							if (class18.anIntArray342[l3] != 0)
								continue;
							ai[l2] = l3;
							ai1[l2] = 0;
							ai2[l2] = 0;
							ai3[l2] = 0;
							l2++;
							break;
						}

					}
					ai[l2] = i3;
					char c = '\0';
					if (class18.anIntArray342[i3] == 3)
						c = '\200';
					if ((j3 & 1) != 0)
						ai1[l2] = stream_3.method421();
					else
						ai1[l2] = c;
					if ((j3 & 2) != 0)
						ai2[l2] = stream_3.method421();
					else
						ai2[l2] = c;
					if ((j3 & 4) != 0)
						ai3[l2] = stream_3.method421();
					else
						ai3[l2] = c;
					k2 = i3;
					l2++;
				}
			}

			class36.stepCount = l2;
			class36.opcodeLinkTable = new int[l2];
			class36.modifier1 = new int[l2];
			class36.modifier2 = new int[l2];
			class36.modifier3 = new int[l2];
			for (int k3 = 0; k3 < l2; k3++) {
				class36.opcodeLinkTable[k3] = ai[k3];
				class36.modifier1[k3] = ai1[k3];
				class36.modifier2[k3] = ai2[k3];
				class36.modifier3[k3] = ai3[k3];
			}

		}

	}

	public static void nullLoader() {
		frameList = null;
	}

	public static Class36 method531(int j) {
		try {
			int fileId = j >> 16;
			Class36 class36 = frameList.get(new Integer(j));
			if (class36 == null) {
				Client.instance.onDemandFetcher.method558(1, fileId);
				return null;
			} else
				return class36;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean method532(int i) {
		return i == -1;
	}

	public Class36() {
	}

	public int anInt636;
	public Class18 aClass18_637;
	public int stepCount; // anInt638
	public int opcodeLinkTable[]; // anIntArray639
	public int modifier1[]; // anIntArray640
	public int modifier2[]; // anIntArray641
	public int modifier3[]; // anIntArray641

}
