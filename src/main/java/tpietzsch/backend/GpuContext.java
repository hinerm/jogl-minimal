package tpietzsch.backend;

import java.nio.Buffer;
import tpietzsch.shadergen.Shader;

public interface GpuContext
{
	// build and cache and bind
	void use( Shader shader );

	// from cached shader thingie and gl context, build SetUniforms
	SetUniforms getUniformSetter( Shader shader );

	/**
	 * @param pbo Pbo to bind
	 * @return id of previously bound pbo
	 */
	int bindPbo( Pbo pbo  );

	/**
	 * @param id pbo id to bind
	 * @return id of previously bound pbo
	 */
	int bindPboId( int id );

	/**
	 * @param texture texture to bind
	 * @return id of previously bound texture
	 */
	int bindTexture( Texture texture );

	/**
	 * @param id texture id to bind
	 * @param numTexDimensions texture target: 1, 2, or 3
	 * @return id of previously bound texture
	 */
	int bindTextureId( int id, int numTexDimensions );

	// map pbo, initialize and cache if necessary
	// previous pbo binding is restored when done
	Buffer map( Pbo pbo );

	// unmap a (mapped) pbo
	// previous pbo binding is restored when done
	void unmap( Pbo pbo );

	// upload texture block fomr pbo
	// previous pbo binding is restored when done
	void texSubImage3D( Pbo pbo, Texture3D texture, int xoffset, int yoffset, int zoffset, int width, int height, int depth, long pixels_buffer_offset );

}