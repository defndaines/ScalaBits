import java.io.ByteArrayOutputStream

import org.apache.avro.Schema
import org.apache.avro.io.{BinaryEncoder, DatumWriter, EncoderFactory}
import org.apache.avro.reflect.ReflectDatumWriter
import org.apache.avro.specific.SpecificRecordBase

class AvroEncoder[A <: SpecificRecordBase](schema: Schema) {

  val encoderFactory: EncoderFactory = EncoderFactory.get()
  val avroWriter: DatumWriter[A] = new ReflectDatumWriter[A](schema)

  def encode(bidPackage: A, reuseEncoder: Option[BinaryEncoder] = Option.empty): Array[Byte] = {
    val stream = new ByteArrayOutputStream
    val binaryEncoder = encoderFactory.binaryEncoder(stream, reuseEncoder.orNull)
    avroWriter.write(bidPackage, binaryEncoder)
    binaryEncoder.flush()
    stream.toByteArray
  }
}
