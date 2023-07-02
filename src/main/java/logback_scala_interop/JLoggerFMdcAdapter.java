package logback_scala_interop;

import ch.qos.logback.classic.util.LogbackMDCAdapter;

import java.util.Map;

/**
 * @author Kevin Lee
 * @since 2023-02-18
 */
public abstract class JLoggerFMdcAdapter extends LogbackMDCAdapter {

  public abstract void setContextMap0(final Map<String, String> contextMap);

  @Override
  public void setContextMap(final Map contextMap) {
    setContextMap0(contextMap);
  }

}
