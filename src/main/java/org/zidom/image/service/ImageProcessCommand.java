package org.zidom.image.service;

/**
 * @author zidom
 *
 */
public class ImageProcessCommand {

	private String name;
	private String extension;
	private int width;
	private int height;
	private boolean hasBackground = false;
	// 压缩比
	private int compressionRatio;

	/**
	 * <code>!</code>Force resize by width.<br/>
	 * <code>_</code>Force resize by height.<br/>
	 */
	private char resizeFlag;

	/**
	 * enum<br>
	 * 
	 * 'S': small size 135x135<br/>
	 * 'M': middle size width 320<br/>
	 * 'L': large size width 640<br/>
	 */
	private char nomalSize;

	/**
	 * Command builder
	 */
	public static class Builder {

		public static Builder build() {
			return new Builder(new ImageProcessCommand());
		}

		private final ImageProcessCommand command;

		/**
		 * @param command
		 */
		public Builder(ImageProcessCommand command) {
			super();
			this.command = command;
		}

		public Builder name(String name) {
			command.name = name;
			return this;
		}

		public Builder width(int width) {
			command.width = width;
			return this;
		}

		public Builder height(int height) {
			command.height = height;
			return this;
		}

		public Builder extension(String extension) {
			command.extension = extension;
			return this;
		}

		public Builder resizeFlag(char resizeFlag) {
			resizeFlag = Character.toUpperCase(resizeFlag);
			assert (resizeFlag == 'N' || resizeFlag == 'F');
			command.resizeFlag = resizeFlag;
			return this;
		}

		/**
		 * 图片的通用大小
		 * 
		 * <pre>
		 * S, small size 135x135 
		 * M, middle size width 320 
		 * L, large size width 640
		 * </pre>
		 * 
		 * @param nomalSize
		 * @return
		 */
		public Builder nomalSize(char nomalSize) {
			nomalSize = Character.toUpperCase(nomalSize);
			assert (nomalSize == 'S' || nomalSize == 'M' || nomalSize == 'L');
			command.nomalSize = nomalSize;
			return this;
		}

		/**
		 * F表示有背景，其他的表示无背景，通常无背景使用N
		 * 
		 * @param nf
		 * @return
		 */
		public Builder hasBackground(char nf) {
			nf = Character.toUpperCase(nf);

			command.hasBackground = (nf == 'F');
			return this;
		}

		/**
		 * 压缩比必须大于0
		 * 
		 * @param ratio
		 * @return
		 */
		public Builder compressionRatio(int ratio) {
			// 压缩比必须要大于一个值
			assert ratio > 0;
			command.compressionRatio = ratio;
			return this;
		}

		public ImageProcessCommand get() {
			return command;
		}

	}

	/**
	 * Use Builder
	 */
	private ImageProcessCommand() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the resizeFlag
	 */
	public char getResizeFlag() {
		return resizeFlag;
	}

	/**
	 * @return the nomalSize
	 */
	public char getNomalSize() {
		return nomalSize;
	}

	/**
	 * @return the hasBackground
	 */
	public boolean isHasBackground() {
		return hasBackground;
	}

	/**
	 * @return the compressionRatio
	 */
	public int getCompressionRatio() {
		return compressionRatio;
	}

}
