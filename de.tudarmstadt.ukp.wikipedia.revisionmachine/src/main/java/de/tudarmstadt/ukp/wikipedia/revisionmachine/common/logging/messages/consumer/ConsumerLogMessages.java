/*******************************************************************************
 * Copyright 2016
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package de.tudarmstadt.ukp.wikipedia.revisionmachine.common.logging.messages.consumer;

import java.util.logging.Level;

import de.tudarmstadt.ukp.wikipedia.revisionmachine.common.exceptions.TimeoutException;
import de.tudarmstadt.ukp.wikipedia.revisionmachine.common.logging.Logger;
import de.tudarmstadt.ukp.wikipedia.revisionmachine.common.util.MathUtilities;
import de.tudarmstadt.ukp.wikipedia.revisionmachine.common.util.Time;

/**
 * This class contains the english localized log messages for Consumers.
 *
 * TODO: This file should be replaced with resource files.
 *
 *
 *
 */
public final class ConsumerLogMessages
{

	/**
	 * Logs the start of a consumer.
	 *
	 * @param logger
	 *            reference to the logger
	 */
	public static void logConsumerRunning(final Logger logger)
	{
		logger.logMessage(Level.INFO, "Consumer is up and running");
	}

	/**
	 * Logs an error.
	 *
	 * @param logger
	 *            reference to the logger
	 * @param e
	 *            reference to the error
	 */
	public static void logError(final Logger logger, final Error e)
	{
		logger.logError(Level.SEVERE, "Unexpected Error", e);
	}

	/**
	 * Logs an exception.
	 *
	 * @param logger
	 *            reference to the logger
	 * @param e
	 *            reference to the exception
	 */
	public static void logException(final Logger logger, final Exception e)
	{
		logger.logException(Level.SEVERE, "Unexpected Exception", e);
	}

	/**
	 * Logs the initialization of a consumer.
	 *
	 * @param logger
	 *            reference to the logger
	 */
	public static void logInitialization(final Logger logger)
	{
		logger.logMessage(Level.INFO, "Consumer initialized [LogLevel: "
				+ logger.getLogLevel() + "]");
	}

	/**
	 * Logs the receival of the kill signal.
	 *
	 * @param logger
	 *            reference to the logger
	 */
	public static void logKillSignalMessage(final Logger logger)
	{
		logger.logMessage(Level.INFO, "Consumer received KILL Signal");
	}

	/**
	 * Logs the receival of the ping signal.
	 *
	 * @param logger
	 *            reference to the logger
	 */
	public static void logPingSignal(final Logger logger)
	{
		logger.logMessage(Level.INFO, "Consumer received PING Signal");
	}

	/**
	 * Logs the shutdown of the consumer.
	 *
	 * @param logger
	 *            reference to the logger
	 * @param endTime
	 *            time
	 */
	public static void logShutdown(final Logger logger, final long endTime)
	{
		logger.logMessage(Level.INFO,
				"Consumer initiates SHUTDOWN\t" + Time.toClock(endTime));
	}

	/**
	 * Logs that the consumer is sleeping.
	 *
	 * @param logger
	 *            reference to the logger
	 */
	public static void logSleep(final Logger logger)
	{
		logger.logMessage(Level.FINER, "Consumer is sleeping");
	}

	/**
	 * Logs the receival of the start signal.
	 *
	 * @param logger
	 *            reference to the logger
	 */
	public static void logStartSignalMessage(final Logger logger)
	{
		logger.logMessage(Level.INFO, "Consumer received START Signal");
	}

	/**
	 * Logs the status of the consumer.
	 *
	 * @param logger
	 *            reference to the logger
	 * @param startTime
	 *            start time
	 * @param sleepingTime
	 *            time the consumer has slept
	 * @param workingTime
	 *            time the consumer was working
	 */
	public static void logStatus(final Logger logger, final long startTime,
			final long sleepingTime, final long workingTime)
	{

		logger.logMessage(
				Level.FINE,
				"Consumer-Status-Report ["
						+ Time.toClock(System.currentTimeMillis() - startTime)
						+ "]" + "\tEFFICIENCY\t "
						+ MathUtilities.percentPlus(workingTime, sleepingTime)
						+ "\tWORK  [" + Time.toClock(workingTime) + "]"
						+ "\tSLEEP [" + Time.toClock(sleepingTime) + "]");
	}

	/**
	 * Logs the receival of the stop signal.
	 *
	 * @param logger
	 *            reference to the logger
	 */
	public static void logStopSignal(final Logger logger)
	{
		logger.logMessage(Level.INFO, "Consumer received STOP Signal");
	}

	/**
	 * Logs the occurance of a TimeoutException.
	 *
	 * @param logger
	 *            reference to the logger
	 * @param e
	 *            reference to the exception
	 */
	public static void logTimeoutException(final Logger logger,
			final TimeoutException e)
	{

		logger.logException(Level.WARNING, "TimeoutException", e);
	}

	/** No object - utility class */
	private ConsumerLogMessages()
	{
	}
}
