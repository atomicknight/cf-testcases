package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ExecutorServiceDecorator implements ExecutorService {
	private final ExecutorService delegate;

	public ExecutorServiceDecorator(ExecutorService delegate) {
		this.delegate = delegate;
	}

	@Override
	public void execute(Runnable command) {
		delegate.execute(decorateTask(command));
	}

	@Override
	public void shutdown() {
		delegate.shutdown();
	}

	@Override
	public List<Runnable> shutdownNow() {
		return delegate.shutdownNow();
	}

	@Override
	public boolean isShutdown() {
		return delegate.isShutdown();
	}

	@Override
	public boolean isTerminated() {
		return delegate.isTerminated();
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return delegate.awaitTermination(timeout, unit);
	}

	@Override
	public <T extends @Nullable Object> Future<T> submit(Callable<T> task) {
		return delegate.submit(decorateTask(task));
	}

	@Override
	public <T extends @Nullable Object> Future<T> submit(Runnable task, T result) {
		return delegate.submit(decorateTask(task), result);
	}

	@Override
	public Future<?> submit(Runnable task) {
		return delegate.submit(decorateTask(task));
	}

	@Override
	public <T extends @Nullable Object> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		return delegate.invokeAll(decorateTasks(tasks));
	}

	@Override
	public <T extends @Nullable Object> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
		return delegate.invokeAll(decorateTasks(tasks), timeout, unit);
	}

	@Override
	public <T extends @Nullable Object> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
		return delegate.invokeAny(decorateTasks(tasks));
	}

	@Override
	public <T extends @Nullable Object> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return delegate.invokeAny(decorateTasks(tasks), timeout, unit);
	}

	protected <T extends @Nullable Object> Collection<? extends Callable<T>> decorateTasks(Collection<? extends Callable<T>> tasks) {
		Collection<Callable<T>> decoratedTasks = new ArrayList<>();
		for(Callable<T> task : tasks) {
			decoratedTasks.add(decorateTask(task));
		}
		return decoratedTasks;
	}

	protected abstract Runnable decorateTask(Runnable task);

	protected abstract <T extends @Nullable Object> Callable<T> decorateTask(Callable<T> task);
}
